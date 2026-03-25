package don.vo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class GameController {

    Game game;

    @FXML
    private AnchorPane gameRootContainer;

    @FXML
    Circle purpleCircle;

    @FXML
    Button writeToFileButton;


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
        GameStateData.playing = false;
        GameStateData.recording = false;

        App.setRoot("lobby");
    }


    @FXML
    void addNotePressed(){
        //this.game.addNoteToScreen(new Note(new TimeStamp("k", new Duration(5000))));
        //Jeg endrer på aaddNoteToScreen til å ta en optional note, denne vil derfor ikke kjøre 
    }

    @FXML 
    void saveRecordToFile(){
        this.game.saveRecordToFile();
    }


    @FXML
    void initialize(){
        this.game = new Game(gameRootContainer);

        //Kan skrive dette i annen klasse hvis jeg ønkser... men ikke nå. 
        if (GameStateData.recording == false){
            this.writeToFileButton.setVisible(false);
        }
        else{
            this.writeToFileButton.setVisible(true);
        }



        //Passer på at vinduet har "focus"
        gameRootContainer.setFocusTraversable(true);

        if (GameStateData.playing){
            gameRootContainer.setOnKeyPressed(event -> {
            System.out.println("Playing");
            this.game.keyPressed(event.getCode().toString());
        
        });
        }

        if (GameStateData.recording){
            gameRootContainer.setOnKeyPressed(event -> {
            System.out.println("Recording");
            this.game.recordingKeyPressed(event.getCode().toString());
        });    
        }

        
        

    }
}
