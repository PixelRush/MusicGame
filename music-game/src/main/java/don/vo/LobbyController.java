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
    private void playSong(ActionEvent event) throws IOException{
        GameStateData.playing = true;
        
        if (LevelEdit.valiLevelEditState()){
            App.setRoot("levelEdit");
        }
        else{
            ErrorHandling.showErrorMessage("No song selected!");
        }
    }

    @FXML
    private void recordSong(ActionEvent event) throws IOException {
        GameStateData.recording = true; 

        if (LevelEdit.valiLevelEditState()){
            App.setRoot("levelEdit");
        }
        else{
            ErrorHandling.showErrorMessage("No song selected!");
        }
    }

    @FXML
    private void initialize(){
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
