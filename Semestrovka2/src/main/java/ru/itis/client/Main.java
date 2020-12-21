package ru.itis.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import ru.itis.client.controllers.IntroController;
import ru.itis.client.model.User;
import ru.itis.protocol.UserAction;

public class Main extends Application {
    protected volatile User user;
    private static int ip = 1;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/markup/intro.fxml"));

            Parent root = loader.load();

            this.user = new User(ip); // как задавать id?
            ip++;

            AppClient appClient = new AppClient(user);

            user.setAction(UserAction.INTRO_MENU);

            IntroController controller = loader.getController();
            controller.setUser(user);

            while (appClient.getMessageAccepter() == null) {
            }

            controller.setMessageAccepter(appClient.getMessageAccepter());

            primaryStage.setTitle("Pixel Battle");
            primaryStage.setScene(new Scene(root));
            primaryStage.setFullScreenExitHint("");
            primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
