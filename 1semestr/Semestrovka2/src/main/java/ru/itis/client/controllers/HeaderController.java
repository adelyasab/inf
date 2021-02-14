package ru.itis.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.itis.client.Main;
import ru.itis.client.model.User;

import java.io.IOException;

public class HeaderController {
    private User user;

    @FXML
    public void options(MouseEvent event) {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("/markup/menu.fxml"));
        try {
            Parent mainLayout = loader.load();

            Menu controller = loader.getController();
            controller.setUser(user);

            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Stage stage = new Stage();
            Scene scene = new Scene(mainLayout);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(appStage);
            stage.show();
        } catch (IOException e) {
        }
    }

    public void setUser(User user){
        this.user = user;
    }
}
