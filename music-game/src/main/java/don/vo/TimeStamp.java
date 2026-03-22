package don.vo;

import javafx.util.Duration;

public class TimeStamp {
    private String key;
    private Duration duration;

    public String getKey() {
        return key;
    }
    public Duration getDuration() {
        return duration;
    }

    public TimeStamp(String key, Duration duration) {
        this.key = key;
        this.duration = duration;
    }
}


