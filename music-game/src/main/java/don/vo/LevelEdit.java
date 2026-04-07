package don.vo;

public class LevelEdit {
    
    static public boolean valiLevelEditState(){
        if (!(GameStateData.playing || GameStateData.recording)){
            return false;
        }
        if (GameStateData.songSelectedID.isEmpty()){
            return false;
        }

        return true;
    }
}
