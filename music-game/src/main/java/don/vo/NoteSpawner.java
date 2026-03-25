package don.vo;

import java.util.ArrayList;
import java.util.Optional;

import javafx.util.Duration;

public class NoteSpawner {
    private int noteSpawnIndex = 0;
    private SongRecord songRecord;
    private ArrayList<Note> noteList;

    public NoteSpawner(SongRecord songRecord){
        this.songRecord = songRecord;
        noteList = songRecordToNoteArrayList(songRecord);
    }

//Only used in the constructor. Could have been in the constructor 
    private ArrayList<Note> songRecordToNoteArrayList(SongRecord songRecord){
         return new ArrayList<Note>(songRecord.getTimeStamps().stream().map(timeStamp-> new Note(timeStamp)).sorted().toList());
    }

    public Optional<Note> spawnNote(Duration duration){
        if (noteSpawnIndex >= noteList.size()){
            return Optional.empty();
        }
        Note currentNote = noteList.get(noteSpawnIndex);
        if (currentNote.shouldSpawn(duration)){
            this.noteSpawnIndex++;
            return Optional.of(currentNote);
        }
        else{
            return Optional.empty();
        }

    }
}
