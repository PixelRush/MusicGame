package don.vo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.util.Duration;

public class FileHandlingTest {

    /**
     * This test is for checking that writing a SongRecord to file and then 
     * reading a new SongRecord from that same file yields the same SongRecord. 
     */
    @Test
    void writeAndReadFile(){

        /* 
        Jeg kunne separert i lesing/skriving, men jeg må skrive lang kode for lesing av fil igjen. 
        Det viktige er kun at det er samsvar mellom lesingen og skrivingen
        Dersom jeg har en SongRecord og lagrer den i en tekstfil, må koden være i stand
        til å rekonstruere samme SongRecord ut ifra tekstfilen, noe denne tester. 
 */
        //Write 
        SongRecord songRecord = new SongRecord();
        songRecord.addStamp(new TimeStamp("A", new Duration(67.00)));
        songRecord.addStamp(new TimeStamp("A", new Duration(69.00)));
        FileHandling.writeSongRecordToFile(songRecord, "JUnit Test.txt");
        
        //Read
        SongRecord songRecord2 = FileHandling.importSongRecordFromFile("JUnit Test.txt");
        assertTrue(songRecord2.isSameRecordAs(songRecord), 
        "The records dont appear to be the same after writing and then reading");
    }

    /**
     * This test is for having an empty SongRecord
     */
    @Test
    void writeAndReadEmptyFile(){
        SongRecord songRecord = new SongRecord();
        FileHandling.writeSongRecordToFile(songRecord, "JUnit Test2.txt");
        //Read
        SongRecord songRecord2 = FileHandling.importSongRecordFromFile("JUnit Test2.txt");
        assertTrue(songRecord2.isSameRecordAs(songRecord), 
        "The records dont appear to be the same after writing and then reading");
    }

     /**
      * This is for testing writing to a file that doesnt exist yet
      * Make sure the file doesnt already exist before running / use a new name
      */
    @Test
    void writeToNewFile(){
        SongRecord songRecord = new SongRecord();
        songRecord.addStamp(new TimeStamp("A", new Duration(67.00)));
        songRecord.addStamp(new TimeStamp("A", new Duration(69.00)));
        FileHandling.writeSongRecordToFile(songRecord, "JUnit Test3.txt");
        //Read
        SongRecord songRecord2 = FileHandling.importSongRecordFromFile("JUnit Test3.txt");
        assertTrue(songRecord2.isSameRecordAs(songRecord), 
        "The records dont appear to be the same after writing and then reading");
    }

    @Test
    void nullSongRecordTest(){
        assertThrows(IllegalArgumentException.class, ()->{
            FileHandling.writeSongRecordToFile(null, "JUnit Test3.txt");
        });

        assertThrows(IllegalArgumentException.class, ()->{
            FileHandling.writeSongRecordToFile(new SongRecord(), null);
        });
    }

}
