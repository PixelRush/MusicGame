package don.vo;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorHandling {

    //Denne kodesnutten for å vise en feilmelding har jeg kopiert. 
    public static void showErrorMessage(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

}
