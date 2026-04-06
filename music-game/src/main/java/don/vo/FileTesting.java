package don.vo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


//DENNE KLASSEN ER IKKE I BRUK

public class FileTesting {

    private static void BufferedWriterTest(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("fileTest\\testy.txt"));
            BufferedWriter writer3 = new BufferedWriter(new FileWriter(Path.of("fileTest", "test69.txt").toString()));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("fileTest\\test2.txt"));
            writer2.write("Hello My son");
            writer.write("Hello World!\nHeres another line!!!!");
            writer.write("\n 2");
            writer3.write("Hello Simba");
            writer3.close();
            
            writer.close();
            writer2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static void BufferedReaderTest(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Paths.get("fileTest", "testy.txt").toString()));
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
            reader.close();          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void printFilesInFolder(Path path){
        try {
            Stream<Path> stream = Files.list(path);
            stream.forEach(System.out::println);
            stream.close();
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> getFilesInFolderArray(Path path){
        ArrayList<String> fileList = new ArrayList<>();
        try {
            Stream<Path> stream = Files.list(path);
            stream.forEach(s->fileList.add(s.toString()));
            stream.close();
            }
        catch (IOException e) {
            e.printStackTrace();
        }
        return fileList;
    }

    private static ArrayList<String> getMusicFileNames(){
        List<String> list = FileTesting.getFilesInFolderArray(Path.of("music-game", "src", "main", "resources", "don", "vo", "music"));
        ArrayList<String> returnList = new ArrayList<>();
        for (String pathString : list) {
            returnList.add(pathString.replace(Path.of("music-game", "src", "main", "resources", "don", "vo", "music").toString() + "\\", "").replace(".mp3", ""));
        }
        return returnList;
    }

    private static List<SongData> LoadSongs(){
        List<SongData> returnList = new ArrayList<>();
        for (String songName : getMusicFileNames()) {
            returnList.add(new SongData(songName, songName));
        }
        return returnList;
    }
    
    public static void main(String[] args) {
        List<String> list = getMusicFileNames();
        for (String string : list) {
            System.out.println(string);
        }

        for (SongData songData : LoadSongs()) {
            System.out.println(songData.getSongName()
            );
        }
    }





}
