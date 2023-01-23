module song {
    requires javafx.controls;
    requires javafx.fxml;

    opens song to javafx.fxml;
    exports song;
}
