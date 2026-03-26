package don.vo;
import javafx.scene.text.Text;

public class TextButton {
    private Text appearance;
    
    public TextButton(String displayString, Runnable function){
        appearance = new Text(displayString);
        this.appearance.setOnMouseClicked(s-> function.run());
    }

    public Text getAppearance() {
        return appearance;
    }

}
