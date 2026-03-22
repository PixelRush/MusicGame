package don.vo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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

    private List<SongData> allSongs = FileHandling.getSongsList();

    @FXML
    void playSong(ActionEvent event) throws IOException{
        GameStateData.playing = true;
        App.setRoot("game");
    }

    @FXML
    void recordSong(ActionEvent event) throws IOException {
        GameStateData.recording = true; 
        App.setRoot("game");
    }

    @FXML
    void initialize(){
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
