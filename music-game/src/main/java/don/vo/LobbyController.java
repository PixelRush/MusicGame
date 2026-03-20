package don.vo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LobbyController {

    @FXML
    private Button playSongButton;

    @FXML
    private Button recordSongButton;

    @FXML
    private Text songSelectedText;

    @FXML
    private VBox songViewVBox;


    private List<SongData> allSongs = new ArrayList<>(List.of(
        new SongData("Barbie Girl", "BarbieGirl"),
        new SongData("Shut Up and Dance", "Shut Up and Dance"),
        new SongData("Geometry Dash level 1", "Geometry Dash"),
        new SongData("Pumped Up Kicks", "Pumped up kicks")
    ));

    @FXML
    void playSong(ActionEvent event) throws IOException{
        App.setRoot("game");
    }

    @FXML
    void recordSong(ActionEvent event) {
        
    }

    /* public LobbyController(){
    } */

    @FXML
    void initialize(){
        //Legger til sangene 
        for (SongData songData : allSongs) {

            SongSelectButton songSelectButton = new SongSelectButton(
                songData.getSongName(),
                songData.getSongID(),
                ()-> {
                    GameStateData.songSelectedID = songData.getSongID();
                    songSelectedText.setText(songData.getSongName());
                });

            songViewVBox.getChildren().add(songSelectButton.getAppearance());
        }


    }


}
