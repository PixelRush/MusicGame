package don.vo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class GameController {

    Game game;

    @FXML
    private AnchorPane gameRootContainer;

    @FXML
    Circle purpleCircle;


    @FXML
    void playMusic(){
        this.game.playSong();
        this.game.play();
        
    }

    @FXML
    void pauseMusic(){
        this.game.pauseSong();
    }

    @FXML
    void back()throws IOException{
        //Må sette på pause fordi den fortsetter... 
        pauseMusic();
        App.setRoot("lobby");
    }


    @FXML
    void addNotePressed(){
        this.game.addNoteToScreen(new Note());
    }


    @FXML
    void initialize(){

        this.game = new Game(gameRootContainer);

        /* gameRootContainer.sceneProperty().addListener((a,b,c)-> {});
        if (gameRootContainer.getScene() != null){

            gameRootContainer.getScene().setOnKeyPressed(keyEvent -> {
            String keyName = keyEvent.getCode().toString();
            System.out.println(keyName + "pressed");
        }
        );
        } */

        //Game game = new Game();
    }
}
