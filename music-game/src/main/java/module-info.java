module don.vo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;
    requires javafx.graphics;
    requires java.xml;
    requires javafx.base;

    opens don.vo to javafx.fxml, javafx.media;
    exports don.vo;

}
