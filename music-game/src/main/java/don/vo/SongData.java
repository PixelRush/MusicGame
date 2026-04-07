package don.vo;

public class SongData {
    private final String songName;
    private final String songID;
    
    public SongData(String songName, String songID) {
        this.songName = songName;
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongID() {
        return songID;
    }

    
}
