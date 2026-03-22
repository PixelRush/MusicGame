package don.vo;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    static void writeSongRecordToFile(SongRecord songRecord){
        
        songRecord.getTimeStamps().stream().forEach(timeStamp -> );
    }

    static SongRecord importSongRecordFromFile(){

        //TODO: Implement this
        return new SongRecord();
    }
}
