module com.example.demineur {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demineur to javafx.fxml;
    exports com.example.demineur;
}