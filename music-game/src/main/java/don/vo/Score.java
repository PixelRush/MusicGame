package don.vo;

public class Score {
    private double score;
    private Song song;

    
    public Score(Song song) {
        this.song = song;
    }

    boolean isOffScreen(Note note){
        if (note.getY() > 1100){
            score-=10;
            return true;
        }
        else{
            return false; 
        }
    }

    /* boolean isHit(Note note){
        if 
    } */





}


