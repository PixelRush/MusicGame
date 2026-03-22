package don.vo;

import java.util.ArrayList;
import java.util.List;

public class SongRecord {
    private List<TimeStamp> timeStamps = new ArrayList<>();

    void addStamp(TimeStamp timeStamp){
        if (timeStamp == null){
            throw new IllegalArgumentException("Program tried to add null TimeStamp object");
        }
        timeStamps.add(timeStamp);
    }

    public List<TimeStamp> getTimeStamps() {
        return timeStamps;
    }

}
