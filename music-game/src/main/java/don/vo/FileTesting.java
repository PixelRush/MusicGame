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
import java.util.stream.Stream;

public class FileTesting {

    static void BufferedWriterTest(){
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


    static void BufferedReaderTest(){
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

    static void getFilesInFolder(Path path){
        try {
            Stream<Path> stream = Files.list(path);
            stream.forEach(System.out::println);
            stream.close();
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        FileTesting.getFilesInFolder(Path.of("fileTest"));
        FileTesting.getFilesInFolder(Path.of("music-game", "src", "main", "resources", "don", "vo", "music"));
    }





}
