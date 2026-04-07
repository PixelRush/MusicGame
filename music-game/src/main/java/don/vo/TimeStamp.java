package don.vo;

import javafx.util.Duration;

public class TimeStamp {
    private final String key;
    private final Duration duration;

    //Begge getters er OK pga final. 
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


    //Denne metoden brukes til JUnit

    @Override
    public boolean equals(Object other){
        if (other instanceof TimeStamp otherTimeStamp) {
            if (otherTimeStamp.duration.equals(this.duration) &&
                otherTimeStamp.key.equals(this.key)){
                return true;
            }
        }
        return false;
    }

    //Denne testen kjører ok. 
    /* public static void main(String[] args) {
        TimeStamp one =new TimeStamp("A", new Duration(10));
        TimeStamp two = new TimeStamp("A", new Duration(10.00));
        System.out.println(one.equals(two));
    } */
}

