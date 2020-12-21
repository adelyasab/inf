package ru.itis.client.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import ru.itis.client.Main;
import ru.itis.client.connection.MessageAccepter;
import ru.itis.client.model.User;
import ru.itis.protocol.UserAction;

import java.io.IOException;
import java.util.Iterator;

public class GameSearchController {
    private Timeline timeline;
    private User user;
    private MessageAccepter messageAccepter;

    @FXML
    private Label gameSearchLabel;

    @FXML
    private Label gameSearchTimer;

    @FXML
    private Label gameSearchCount;

    @FXML
    private void options(MouseEvent event) {
        HeaderController controller = new HeaderController();
        controller.setUser(user);
        controller.options(event);
    }

    @FXML
    public void goBack(MouseEvent event){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("/markup/intro.fxml"));
        try {
            Parent mainLayout = loader.load();

            user.setAction(UserAction.INTRO_MENU);
            IntroController controller = loader.getController();
            controller.setUser(user);

            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.getScene().setRoot(mainLayout);
        } catch (IOException e) {
        }
    }

    @FXML
    void initialize() {
        assert gameSearchLabel != null : "fx:id=\"gameSearchLabel\" was not injected: check your FXML file 'gameSearch.fxml'.";
        assert gameSearchTimer != null : "fx:id=\"gameSearchTimer\" was not injected: check your FXML file 'gameSearch.fxml'.";

        this.timeline = new Timeline (
                new KeyFrame(
                        Duration.millis(1000),

                        ae -> {
                            int usersCount =  messageAccepter.getUsers().size() + 1;
                            user.setAction(UserAction.BATTLE_SEARCH);
                            if(usersCount == 2){
                                this.timeline.stop();

                                FXMLLoader loader=new FXMLLoader();
                                loader.setLocation(Main.class.getResource("/markup/map.fxml"));

                                try {
                                    Parent mainLayout = loader.load();

                                    MapController controller = loader.getController();

                                    Iterator<User> iterator = messageAccepter.getUsers().iterator();
                                    while(iterator.hasNext()){
                                        User enemy = iterator.next();
                                        if(!enemy.equals(this.user)){
                                            controller.setEnemy(enemy);
                                            break;
                                        }
                                    }

                                    user.setAction(UserAction.IN_THE_BATTLE);
                                    controller.setUser(user);

                                    controller.drawUser();
                                    controller.initUserActions();
                                    controller.drawEnemy();
                                    controller.initEnemyActions();

                                    Stage appStage = (Stage) gameSearchLabel.getScene().getWindow();
                                    appStage.getScene().setRoot(mainLayout);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                )
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setMessageAccepter(MessageAccepter messageAccepter) { this.messageAccepter = messageAccepter; }
}
