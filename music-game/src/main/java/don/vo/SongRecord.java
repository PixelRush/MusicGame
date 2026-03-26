package don.vo;

import java.util.ArrayList;
import java.util.List;

public class SongRecord {
    private List<TimeStamp> timeStamps = new ArrayList<>();
    private String songID; //Denne brukes ingen steder, kanskje droppe det? 

    void addStamp(TimeStamp timeStamp){
        if (timeStamp == null){
            throw new IllegalArgumentException("Program tried to add null TimeStamp object");
        }
        timeStamps.add(timeStamp);
    }

    //Denne konstruktøren har jeg ikke brukt enda
    public SongRecord(String songID){
        this.songID = songID;
    }

    public SongRecord(){
        this.songID = "";
    }

    public List<TimeStamp> getTimeStamps() {
        return timeStamps;
    }

}
