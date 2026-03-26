package don.vo;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LevelEditController {

    @FXML
    private Button playSongButton;

    @FXML
    private Text levelSelectedText;

    @FXML
    private VBox songViewVBox;

    private ArrayList<String> songRecordNameList = new ArrayList<>();

    @FXML
    void playSong(ActionEvent event) throws IOException {
        App.setRoot("game");
    }

    @FXML
    void backButtonPressed(ActionEvent event) throws IOException{
        GameStateData.songRecordSelectedID = "Empty";
        GameStateData.recording = false;
        GameStateData.playing = false;
        App.setRoot("lobby");
    }

    @FXML
    void initialize(){
        songRecordNameList = FileHandling.getSongRecordsFromSong(GameStateData.songSelectedID);
        for (String string : songRecordNameList) {
            songViewVBox.getChildren().add(new TextButton(string, ()->{
                GameStateData.songRecordSelectedID = string;
                levelSelectedText.setText(string);
            }).getAppearance());
        }
    }

}
