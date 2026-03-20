package don.vo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GameController {


    @FXML
    private AnchorPane gameRootContainer;

    private Song music = new Song(GameStateData.songSelectedID);

    @FXML
    void playMusic(){
        music.play();
        
    }

    @FXML
    void pauseMusic(){
        music.pause();
    }

    @FXML
    void back()throws IOException{
        //Må sette på pause fordi den fortsetter... 
        pauseMusic();
        App.setRoot("lobby");
    }

    @FXML
    void initialize(){

        gameRootContainer.sceneProperty().addListener((a,b,c)-> {});
        if (gameRootContainer.getScene() != null){

            gameRootContainer.getScene().setOnKeyPressed(keyEvent -> {
            String keyName = keyEvent.getCode().toString();
            System.out.println(keyName + "pressed");
        }
        );
        }
        
    }
}
