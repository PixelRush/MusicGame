module don.vo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;
    requires javafx.graphics;

    opens don.vo to javafx.fxml, javafx.media;
    exports don.vo;

}
