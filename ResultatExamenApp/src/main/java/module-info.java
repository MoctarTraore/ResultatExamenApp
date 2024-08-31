module com.example.consultationresultats {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.resultatexamen to javafx.fxml;
    exports com.example.resultatexamen;
}
