package don.vo;

import java.io.IOException;
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

    private List<SongData> allSongs = FileHandling.getSongsList();

    @FXML
    void playSong(ActionEvent event) throws IOException{
        GameStateData.playing = true;
        //TODO: Kanskje legge til en sjekk om at en sang er valgt. 
        App.setRoot("levelEdit");
    }

    @FXML
    void recordSong(ActionEvent event) throws IOException {
        GameStateData.recording = true; 
        App.setRoot("levelEdit");
    }

    @FXML
    void initialize(){
        for (SongData songData : allSongs) {

            TextButton songSelectButton = new TextButton(
                songData.getSongName(),
                ()-> {
                    GameStateData.songSelectedID = songData.getSongID();
                    songSelectedText.setText(songData.getSongName());
                });

            songViewVBox.getChildren().add(songSelectButton.getAppearance());
        }
    }

}
