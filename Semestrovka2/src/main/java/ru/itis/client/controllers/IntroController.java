package ru.itis.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import ru.itis.client.Main;
import ru.itis.client.connection.MessageAccepter;
import ru.itis.client.model.User;
import ru.itis.protocol.UserAction;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IntroController {
    private User user;
    private MessageAccepter messageAccepter;

   @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button toBattleButton;

    @FXML
    private Button exitMenuButton;

    @FXML
    private Button optionsMenuButton;

    @FXML
    private FlowPane optionsPane;

    @FXML
    private void options(MouseEvent event) {
        HeaderController controller = new HeaderController();
        controller.setUser(user);
        controller.options(event);
    }

    @FXML
    private void toBattle(MouseEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/markup/gameSearch.fxml"));
        try {
            Parent mainLayout = loader.load();

            user.setAction(UserAction.BATTLE_SEARCH);
            GameSearchController controller = loader.getController();
            controller.setUser(user);
            controller.setMessageAccepter(messageAccepter);

            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.getScene().setRoot(mainLayout);
        } catch (IOException e) {
        }
    }

    @FXML
    void initialize() {
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setMessageAccepter(MessageAccepter messageAccepter) { this.messageAccepter = messageAccepter; }
}