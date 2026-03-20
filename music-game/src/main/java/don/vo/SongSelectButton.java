package don.vo;
import javafx.scene.text.Text;

public class SongSelectButton {
    Text appearance;
    String songTitle;
    String songID;
    
    public SongSelectButton(String songName, String songID, Runnable function){
        appearance = new Text(songName);
        this.songID = songID;
        this.songTitle = songName;
        this.appearance.setOnMouseClicked(s-> function.run());
    }

    public Text getAppearance() {
        return appearance;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getSongID() {
        return songID;
    }

    



    
}
