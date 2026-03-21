package don.vo;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Game {

    private Song song;

    private List<Note> notes = new ArrayList<>();

    private AnchorPane screen;

    public Game(AnchorPane anchorPane){
        if (anchorPane == null){
            throw new IllegalArgumentException("Game constructor was called with null argument");
        }
        this.screen = anchorPane;
        this.song = new Song(GameStateData.songSelectedID);
    }

    public void addNoteToScreen(Note note){
        if (note == null){
            throw new IllegalArgumentException("Cannot add null note to screen");
        }
        notes.add(note);
        this.screen.getChildren().add(note.getAppeareance());
    }

    public void playSong(){
        this.song.play();
    }

    public void pauseSong(){
        this.song.pause();
    }

    private Duration getSongTime(){
        return this.song.getCurrentTime();
    }

    private Duration getSongEnd(){
        return this.song.getEndTime();
    }

    private Duration getSongStart(){
        return this.song.getStartTime();
    }

    private void removeNote(Note note){
        if (note == null){
            throw new IllegalArgumentException("Cannot remove null note");
        }
        if (!notes.contains(note)){
            throw new IllegalStateException("Tried to remove a note that isnt in Notes");
        }
        this.notes.remove(note);
    }

    
    
    void play(){

        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                for (Note note : notes) {
                    note.moveTo(getSongTime(), getSongStart(), new Duration(5000), note.getY(), 0, 1000);
                }
            }
            
        };

        animationTimer.start();

    }


}
