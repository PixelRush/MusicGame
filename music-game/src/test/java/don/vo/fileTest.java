package don.vo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.util.Duration;

public class fileTest {
    @Test
    void writeAndReadFile(){

        //Jeg kunne separert dem, men jeg må uansett lese igjen for å kunne teste.
        //Dessuten er det viktigste kun at det er samsvar mellom lesingen og skrivingen. 

        //Write 
        SongRecord songRecord = new SongRecord();
        songRecord.addStamp(new TimeStamp("A", new Duration(67.00)));
        FileHandling.writeSongRecordToFile(songRecord, "JUnit Test.txt");
        
        //Read
        SongRecord songRecord2 = FileHandling.importSongRecordFromFile("JUnit Test.txt");

        assertTrue(songRecord2.isSameRecordAs(songRecord), 
        "The records dont appear to be the same after writing and then reading");

    }
}
