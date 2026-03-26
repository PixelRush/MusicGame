package don.vo;

import java.util.HashMap;
import java.util.Map;

public class GameStateData {
    static String songSelectedID = "BarbieGirl";
    static String songRecordSelectedID = "Empty";
    static int frameRate = 60;
    static double timeBeforeHit = 700; //I milisekunder 
    static double noteSpawnY = 0;
    static boolean recording = false;
    static boolean playing = false; 
    

    //Score
    static double perfectOffset = 0;
    

    //Pass på at alle keybindsmap har et map til note spawn positions også 
    static HashMap<String, String> keyBindsMap = new HashMap<>(Map.of(
        "Key", "Value",
        "B", "1",
        "U", "2",
        "I", "3",
        "O", "4",
        "P", "5"
    ));
    static HashMap<String, Double> noteSpawnPositions = new HashMap<>(Map.of(
        "1", 250.0,
        "2", 290.0,
        "3", 330.0,
        "4", 370.0,
        "5", 410.0,
        "Default", 500.0
    ));
}
