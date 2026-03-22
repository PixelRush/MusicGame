package don.vo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javafx.util.Duration;

public class FileHandling {
    /* URL url = getClass().getResource("/don/vo/music");
    //URL url2 = FileHandling.class.getResource("/don/vo/music"); */

    static List<SongData> getSongsList(){
        URL url1 = FileHandling.class.getResource("/don/vo/music");
        List<SongData> returnList = new ArrayList<>();
        try {
            File file = new File(url1.toURI());
            Stream<File> stream = Arrays.stream(file.listFiles());
            stream.forEach(f -> returnList.add(new SongData(f.getName().replace(".mp3", ""), f.getName().replace(".mp3", ""))));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return returnList;

    }

    static void writeSongRecordToFile(SongRecord songRecord, String name){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of("fileTest", name).toString()));

            //Må bruke enda en try catch inni lambdaen...
            songRecord.getTimeStamps().stream().forEach(timeStamp -> {
                try {
                    writer.write(timeStamp.getKey());
                    writer.write(":");
                    writer.write(String.valueOf(timeStamp.getDuration().toMillis())+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }

    static SongRecord importSongRecordFromFile(){

        //TODO: Implement this
        return new SongRecord();
    }

    public static void main(String[] args) {
        SongRecord songRecord = new SongRecord();
        songRecord.addStamp(new TimeStamp("A", new Duration(1000)));
        songRecord.addStamp(new TimeStamp("A", new Duration(2069)));
        songRecord.addStamp(new TimeStamp("A", new Duration(2069.0001)));

        writeSongRecordToFile(songRecord, "TestRecord.txt");
    }
}
