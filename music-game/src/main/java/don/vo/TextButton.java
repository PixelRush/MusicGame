package don.vo;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextButton {
    private Text appearance;
    
    public TextButton(String displayString, Runnable function){
        appearance = new Text(displayString);
        this.appearance.setOnMouseClicked(s-> function.run());
        this.appearance.setFont(Font.font(20));
    }

    public Node getAppearance(){
        return appearance;
    }

}
