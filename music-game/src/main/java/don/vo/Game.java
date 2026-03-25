package don.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Game {

    private Song song;

    private List<Note> notes = new ArrayList<>();

    private AnchorPane screen;

    private SongRecord songRecord;

    private NoteSpawner noteSpawner;

    public Game(AnchorPane anchorPane){
        if (anchorPane == null){
            throw new IllegalArgumentException("Game constructor was called with null argument");
        }
        this.screen = anchorPane;
        this.song = new Song(GameStateData.songSelectedID);
        this.songRecord = FileHandling.importSongRecordFromFile(GameStateData.songSelectedID + ".txt");
        this.noteSpawner = new NoteSpawner(this.songRecord);
    }

    public void addNoteToScreen(Optional<Note> optionalNote){
        Note note;
        if (optionalNote.isPresent()){
            note = optionalNote.get();
            notes.add(note);
            this.screen.getChildren().add(note.getAppeareance());
        }
        
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

    public void keyPressed(String key){
        System.out.println("Key pressed: " + key + "at " + getSongTime().toString());
    }

    public void recordingKeyPressed(String key){
        System.out.println("Recording this key: " + key + "    At time: " + getSongTime().toString());
        this.songRecord.addStamp(new TimeStamp(key, getSongTime()));
    }

    public void saveRecordToFile(){
        FileHandling.writeSongRecordToFile(songRecord, "TestRecord.txt");
    }
    
    
    /*
    Denne kalles når play knappen trykkes på */
    void play(){

        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                addNoteToScreen(noteSpawner.spawnNote(getSongTime()));

                for (Note note : notes) {
                    note.moveTo(getSongTime(), note.getY(), 0, 1000);
                }
                
            }  
        };

        animationTimer.start();

    }


}
