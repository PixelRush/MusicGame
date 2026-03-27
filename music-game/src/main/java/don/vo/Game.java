package don.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Game {

    private Song song;

    private List<Note> notesOnScreen = new ArrayList<>();
    private List<Note> notesToBeRemoved = new ArrayList<>();


    private AnchorPane screen;

    private Text scoreCounter;

    private SongRecord songRecord;

    private NoteSpawner noteSpawner;

    private Score score;

    private HBox fretHBox;

    public Game(AnchorPane anchorPane, Text scoreCounter, HBox fretHBox){
        if (anchorPane == null || scoreCounter == null || fretHBox == null){
            throw new IllegalArgumentException("Game constructor was called with null argument");
        }
        this.scoreCounter = scoreCounter;
        this.screen = anchorPane;
        this.fretHBox = fretHBox;
        this.song = new Song(GameStateData.songSelectedID);

        //Denne linjen under feiler hvis det ikke finnes en slik fil, uansett om du trykker play eller record 
        // det er fordi denne konstruktøren alltid prøver å lage SongRecord objektet. 
        this.songRecord = FileHandling.importSongRecordFromFile(GameStateData.songRecordSelectedID + ".txt");
        setNoteSpawnLocations(this.fretHBox.getLayoutX()); //Det er viktig at disse settes før notene lages!!! 
        this.noteSpawner = new NoteSpawner(this.songRecord);
        this.score = new Score(this.song);
    }

    public void addNoteToScreen(Optional<Note> optionalNote){
        Note note;
        if (optionalNote.isPresent()){
            note = optionalNote.get();
            notesOnScreen.add(note);
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

    private void emptyNoteBin(){
        for (Note note : notesToBeRemoved) {
            if (note == null){
            throw new IllegalArgumentException("Cannot remove null note");
        }
        if (!notesOnScreen.contains(note)){
            throw new IllegalStateException("Tried to remove a note that isnt in Notes");
        }
        this.notesOnScreen.remove(note);
        this.screen.getChildren().remove(note.getAppeareance());
        }
        this.notesToBeRemoved.clear();

        //Kanskje denne metoden ikke burde være her
        //this.scoreCounter.setText(String.valueOf(this.score.getScore()));
    }

    private void updateScore(){
        this.scoreCounter.setText(String.valueOf(this.score.getScore()));
    }

    private void addNoteToTrash(Note note){
        if (notesToBeRemoved.contains(note)){
            return;
        }
        this.notesToBeRemoved.add(note);
    }

    //Kjører når en tast trykkes på og spiller har valgt play og ikke record. 
    public void keyPressed(String key){
        System.out.println("Key pressed: " + key + "at " + getSongTime().toString());
        for (Note note : notesOnScreen) {
            if (note.getKey().equals(key)){
                if (this.score.isHit(note)) {
                    addNoteToTrash(note);
                }
            }
        }
    }

    public void recordingKeyPressed(String key){
        System.out.println("Recording this key: " + key + "    At time: " + getSongTime().toString());
        this.songRecord.addStamp(new TimeStamp(key, getSongTime()));
    }

    public void saveRecordToFile(){
        //TODO: Må finne en måte å velge filnavn? For nå bruker jeg default. 
        FileHandling.writeSongRecordToFile(songRecord, GameStateData.songRecordSelectedID + ".txt");
    }
    
    public void setNoteSpawnLocations(double x){
        ArrayList<Double> circlePositions = new ArrayList<>();
        for (int i = 0; i < GameStateData.numberOfFretNotes; i++) {
            circlePositions.add(x+GameStateData.fretCircleRadius*2*i+GameStateData.fretSpacing*i+GameStateData.fretCircleRadius);
            GameStateData.noteSpawnPositions.replace(i+1, circlePositions.get(i));

        }

        
        
    }

    public void debug(){
        System.out.println("Debugging");
    }
    
    /*
    Denne kalles når play knappen trykkes på */
    void play(){

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                addNoteToScreen(noteSpawner.spawnNote(getSongTime()));

                for (Note note : notesOnScreen) {
                    note.moveTo(getSongTime(), note.getY(), 50, 700);
                    if (score.isOffScreen(note)){
                        addNoteToTrash(note);
                        scoreCounter.setText(String.valueOf(score.getScore()));
                    }
                }
                emptyNoteBin();
                updateScore();
            }
        };
        animationTimer.start();

    }


}
