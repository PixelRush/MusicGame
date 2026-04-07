package don.vo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameController {

    Game game;

    @FXML
    private AnchorPane gameRootContainer;

    @FXML
    private Circle purpleCircle;

    @FXML
    private Button writeToFileButton;

    @FXML 
    private Text scoreCounter;

    @FXML
    private HBox fretHBox;


    @FXML
    private void playMusic(){
        this.game.playSong();
        this.game.play();
        
    }

    @FXML
    private void pauseMusic(){
        this.game.pauseSong();
    }

    @FXML
    private void back()throws IOException{
        //Må sette på pause fordi den fortsetter... 
        pauseMusic();
        GameStateData.playing = false;
        GameStateData.recording = false;
        GameStateData.songRecordSelectedID = "";
        GameStateData.songSelectedID = "";
        App.setRoot("lobby");
    }

    @FXML
    private void debug(){
        this.game.debug();
    }


    //Gammel funksjon... 
    @FXML
    private void addNotePressed(){
        //this.game.addNoteToScreen(new Note(new TimeStamp("k", new Duration(5000))));
        //Jeg endrer på aaddNoteToScreen til å ta en optional note, denne vil derfor ikke kjøre 
    }

    @FXML 
    private void saveRecordToFile(){
        this.game.saveRecordToFile();
    }


    @FXML
    private void initialize(){
        this.game = new Game(this.gameRootContainer, this.scoreCounter, this.fretHBox);

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
            this.game.keyPressed(event.getCode().toString());
        
        });
        }

        if (GameStateData.recording){
            gameRootContainer.setOnKeyPressed(event -> {
            this.game.recordingKeyPressed(event.getCode().toString());
        });    
        }

        
        

    }
}
