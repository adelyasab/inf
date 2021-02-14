module queen {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    exports ru.itis.client to javafx.graphics;
    opens ru.itis.client.controllers;
}