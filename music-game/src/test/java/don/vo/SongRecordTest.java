package don.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.util.Duration;

public class SongRecordTest {

    SongRecord songRecord;
    
    @BeforeEach
    void setup(){
        songRecord = new SongRecord();
    }

    @Test
    void addingTimeStamps(){
        songRecord.addStamp(new TimeStamp("A", new Duration(67.00)));
        assertEquals(songRecord.getTimeStamps(), 
        List.of(new TimeStamp("A", new Duration(67.00)))
    );
    }

    /**
     * This test checks that you cannot modify the SongRecord field through the getTimeStamps() method
     * It should return a shallow copy, but since the TimeStamps are immutable, it should be fine. :)))))
     */
    @Test
    void timeStampListIsImmutable(){
        songRecord.addStamp(new TimeStamp("A", new Duration(67.00)));

        assertThrows(UnsupportedOperationException.class, ()->{
            songRecord.getTimeStamps().add(new TimeStamp("A", new Duration(69)));
        });

        //Redundant, but i have it here anyways for readability?... 
        assertTrue(songRecord.getTimeStamps().size() == 1, "songRecord must remain unchanged!");
    }

    @Test
    void addingNullTimeStamp(){
        assertThrows(IllegalArgumentException.class, ()->{
            songRecord.addStamp(null);
        });
    }

}
