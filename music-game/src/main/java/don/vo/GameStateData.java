package don.vo;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;

public class GameStateData {
    static String songSelectedID = "BarbieGirl";
    static String songRecordSelectedID = "Empty";
    static int frameRate = 60;
    static boolean recording = false;
    static boolean playing = false; 
    

    //Gameplay 
    static double latency = 0; //Dersom notene kommer for sent, må du ha negativ verdi her
    //25ms latency for bose headsetet
    static double timeBeforeHit = 500; //I milisekunder 

    //Score
    static double perfectOffset = 50;
    static double goodOffset = 100;
    static double perfectScore = 100;
    static double goodScore = 50;
    static double missPenaltyScore = 200;

    //Layout
    static double fretSpacing = 10;
    static double fretCircleRadius = 30;
    static int numberOfFretNotes = 10;
    static double noteSpawnY = 50.0;
    static double fretY = 607+fretCircleRadius;

    //Dette mappet er laget av gemini, og matcher ikke helt fargen jeg har i fxml. 
    static final Map<Integer, Color> NOTE_COLORS = new HashMap<>() {{
    put(1, Color.web("#7b1fa2")); // Deep Purple 
    put(2, Color.web("#e51fff")); // Purple
    put(3, Color.web("#ff1f6b")); // Pink/Magenta
    put(4, Color.web("#ff1f1f")); // Red
    put(5, Color.web("#ff991f")); // Orange
    put(6, Color.web("#fff11f")); // Yellow
    put(7, Color.web("#c0ff21")); // Lime
    put(8, Color.web("#24c72b")); // Green
    put(9, Color.web("#12d0d0")); // Cyan
    put(10, Color.web("#136ccf")); // Blue
    put(67, Color.WHITE);
}};

    static int defaultKey = 67;

    //Pass på at alle keybindsmap har et map til note spawn positions også 
    /* static HashMap<String, Integer> keyBindsMap = new HashMap<>(Map.of(
        "B", 1,
        "U", 2,
        "I", 3,
        "O", 4,
        "P", 5,
        "DIGIT1", 1,
        "DIGIT2", 2,
        "DIGIT3", 3,
        "DIGIT4", 4,
        "default", 67
    )); */
    /*
    Default key er 67 
    */
    /* static HashMap<Integer, Double> noteSpawnPositions = new HashMap<>(Map.of(
        1, 250.0,
        2, 290.0,
        3, 330.0,
        4, 370.0,
        5, 410.0,
        67, 500.0
    )); */

    static HashMap<String, Integer> keyBindsMap = new HashMap<>(Map.ofEntries(
    Map.entry("Q", 1), Map.entry("DIGIT1", 1),
    Map.entry("W", 2), Map.entry("DIGIT2", 2),
    Map.entry("E", 3), Map.entry("DIGIT3", 3),
    Map.entry("R", 4), Map.entry("DIGIT4", 4),
    Map.entry("V", 5), Map.entry("DIGIT5", 5),

    Map.entry("B", 6), Map.entry("DIGIT6", 6),
    Map.entry("U", 7), Map.entry("DIGIT7", 7),
    Map.entry("I", 8), Map.entry("DIGIT8", 8),
    Map.entry("O", 9), Map.entry("DIGIT9", 9),
    Map.entry("P", 10), Map.entry("DIGIT0", 10),

    Map.entry("default", defaultKey)
));

    static HashMap<Integer, Double> noteSpawnPositions = new HashMap<>(Map.ofEntries(
    Map.entry(1, 250.0),
    Map.entry(2, 290.0),
    Map.entry(3, 330.0),
    Map.entry(4, 370.0),
    Map.entry(5, 410.0),
    Map.entry(6, 450.0), 
    Map.entry(7, 490.0),
    Map.entry(8, 530.0),
    Map.entry(9, 570.0),
    Map.entry(10, 610.0),
    Map.entry(defaultKey, 500.0) // Default 
));
}
