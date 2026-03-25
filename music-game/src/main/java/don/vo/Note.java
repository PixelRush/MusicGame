package don.vo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Note implements Comparable<Note>{
    Circle appeareance;
    Duration spawDuration;
    Duration hitDuration;
    String key;

    public Note(){
        this.appeareance = new Circle(50, Color.web("#9421ff"));
    }

    public Note(TimeStamp timeStamp){
        this.appeareance = new Circle(50, Color.AQUA);
        this.hitDuration = timeStamp.getDuration();
        this.spawDuration = new Duration(hitDuration.toMillis()-GameStateData.timeBeforeHit);
        this.key = timeStamp.getKey();
        this.appeareance.setLayoutX(getY());
    }

    public Circle getAppeareance() {
        return appeareance;
    }

    double getY(){
        return this.appeareance.getLayoutY();
    }

    public void move(double amount){
        this.appeareance.setLayoutY(this.appeareance.getLayoutY()+amount);
    }

    public void moveTo(Duration currentTime, double currentY, double startY, double endY){
       Duration travelDuration = this.hitDuration.subtract(this.spawDuration);
       double totalTravelDistance = endY - startY;
       double correctPosition = (currentTime.subtract(this.spawDuration).toMillis()/travelDuration.toMillis())*totalTravelDistance+startY;
       this.appeareance.setLayoutY(correctPosition); 
    }

    @Override
    public int compareTo(Note otherNote) {
        return Double.compare(this.getSpawDuration().toMillis(), otherNote.getSpawDuration().toMillis());
    }

    public Duration getSpawDuration() {
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
