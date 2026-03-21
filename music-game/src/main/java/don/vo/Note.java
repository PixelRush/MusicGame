package don.vo;

import java.util.Calendar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Note {
    Circle appeareance;
    String key;

    public Note(){
        this.appeareance = new Circle(50, Color.AQUA);
        this.key = "t";
    }

    public Circle getAppeareance() {
        return appeareance;
    }

    double getY(){
        return this.appeareance.getLayoutY();
    }

    public String getKey() {
        return key;
    }

    public void move(double amount){
        this.appeareance.setLayoutY(this.appeareance.getLayoutY()+amount);
    }

    //Feedback: Denne metoden funker, men ved fram skips, går ting ut av sync! 
    //Husk at hvis du vil bruke denne igjen, må du oppdatere metodekallet i Game fordi den tar inn 2 args. 

    /* public void moveTo(double time, double startY, double endY){
        double distanceToMove = endY-startY;
        //Distance per frame er distanceToMove delt på antall frames. 
        //Antall frames er 60 * antall sekunder. Time er i ms for å være konsekvent. 
        double distancePerFrame = distanceToMove/(60*(time/1000));
        this.getAppeareance().setLayoutY(distancePerFrame+this.getAppeareance().getLayoutY());
    } */


    //Denne metoden fungerer heller ikke bra, når kulen nærmer seg, får jeg deling på et veldig lite tall!!

    /* public void moveTo2(Duration currentTime, Duration endTime, double currentY, double endY){
       Duration travelDuration = endTime.subtract(currentTime);
       double travelDistance = endY - currentY;
       //Formula for distance should be travelDistance / total #frames. And # frames = framerate*seconds. 
       double distancePerFrame = travelDistance/(GameStateData.frameRate*travelDuration.toSeconds());

       if (currentY >= endY){
        //Continue moving! Do not go backwards :) 
       }

       this.appeareance.setLayoutY(getY()+distancePerFrame);

    } */

    public void moveTo(Duration currentTime, Duration spawnTime, Duration endTime, double currentY, double startY, double endY){
       //Calculate the position it should be at based on the currentTime

       Duration travelDuration = endTime.subtract(spawnTime);
       double totalTravelDistance = endY - startY;

       //Formula: % of time passed should match % of distance traveled. 

       //Denne er feil for mange grunner...
       /* double correctPosition = (currentTime.toMillis()/travelDuration.toMillis())*totalTravelDistance;
        */

        double correctPosition = (currentTime.subtract(spawnTime).toMillis()/travelDuration.toMillis())*totalTravelDistance+startY;
        this.appeareance.setLayoutY(correctPosition); 
    }
       




}
