package don.vo;
import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Song {
    private Media media;
    private MediaPlayer mediaPlayer;

    public Song(String songID){
        URL resource = getClass().getResource("/don/vo/music/" + songID + ".mp3");
        media = new Media(resource.toString()); //Media tar 
        System.out.println("Oooh");
        mediaPlayer = new MediaPlayer(media);
    }

    public void play(){
        mediaPlayer.play();
        
    }

    public void pause(){
        mediaPlayer.pause();
    }


    public Duration getCurrentTime(){
        return mediaPlayer.getCurrentTime();
    }
    
}
