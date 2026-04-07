package don.vo;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Note implements Comparable<Note>{
    private Circle appeareance;
    private final Duration spawDuration;
    private final Duration hitDuration;
    private final String key;

    //Denne brukes ikke lenger... 
    /* private Note(){
        this.appeareance = new Circle(50, Color.web("#9421ff"));
    } */

    public Note(TimeStamp timeStamp){
        this.appeareance = new Circle(30, Color.AQUA);
        this.hitDuration = timeStamp.getDuration().add(new Duration(GameStateData.latency));
        this.spawDuration = new Duration(hitDuration.toMillis()-GameStateData.timeBeforeHit);

        if (GameStateData.keyBindsMap.containsKey(timeStamp.getKey())){
            this.key = timeStamp.getKey();
        }
        else{
            this.key = "default";
        }
        this.appeareance.setLayoutX(
            GameStateData.noteSpawnPositions.get(
                GameStateData.keyBindsMap.getOrDefault(key, GameStateData.defaultKey)
            ));
        Paint paint = GameStateData.NOTE_COLORS.get(GameStateData.keyBindsMap.getOrDefault(this.key, 67));
        this.appeareance.setFill(paint);
    }

    //Endret returverdi fra Circle til Note slik at man ikke får tilgang til Circle metoder, f.eks. setRadius()...
    public Node getAppeareance() {
        return appeareance;
    }

    double getY(){
        return this.appeareance.getLayoutY();
    }

    public void move(double amount){
        this.appeareance.setLayoutY(this.appeareance.getLayoutY()+amount);
    }

    public void moveTo(Duration currentTime, double startY, double endY){
       Duration travelDuration = this.hitDuration.subtract(this.spawDuration);
       double totalTravelDistance = endY - startY;
       double correctPosition = (currentTime.subtract(this.spawDuration).toMillis()/travelDuration.toMillis())*totalTravelDistance+startY;
       this.appeareance.setLayoutY(correctPosition); 
    }

    //Implemtasjon av comparabe 
    @Override
    public int compareTo(Note otherNote) {
        //Kunne ikke bare returnere differansen i toMillis pga int returverdi. Kunne bruke if setning,
        //men det var en enkel innebygd static metode for Double. 
        return Double.compare(this.getSpawDuration().toMillis(), otherNote.getSpawDuration().toMillis());
    }

    //Alle tre getters er OK selv om de er muterbare pga jeg har satt dem som final. 
    private Duration getSpawDuration() {
        return spawDuration;
    }

    public Duration getHitDuration() {
        return hitDuration;
    }

    public String getKey() {
        return key;
    }
    
    public boolean shouldSpawn(Duration duration){
        if (duration.greaterThanOrEqualTo(this.spawDuration)){
            return true;
        }
        else {
            return false;
        }
    }

}
