package don.vo;

public class Score {
    private double score;
    private Song song;

    
    public Score(Song song) {
        this.song = song;
    }

    boolean isOffScreen(Note note){
        if (note.getY() > 1100){
            this.score-=10;
            return true;
        }
        else{
            return false; 
        }
    }

    boolean isHit(Note note){
        double reaction = Math.abs(note.getHitDuration().subtract(song.getCurrentTime()).toMillis());
        if (reaction <= GameStateData.perfectOffset){
            this.score += 100;
            return true;
        }
        else if(reaction <= GameStateData.goodOffset){
            this.score += 50;
            return true;
        }
        else{
            return false; 
        }
    }
    
    public double getScore(){
        return this.score;
    }



}


