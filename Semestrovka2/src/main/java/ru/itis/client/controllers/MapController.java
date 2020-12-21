package ru.itis.client.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import ru.itis.client.model.User;
import ru.itis.client.model.tanks.Tank;
import ru.itis.client.model.tanks.shots.Shot;
import ru.itis.client.model.walls.StandartWall;
import ru.itis.client.model.walls.UnbrokenWall;
import ru.itis.client.model.walls.Wall;
import ru.itis.protocol.UserAction;

public class MapController {
    private volatile User user;
    private volatile User enemy;

    @FXML
    public Button optionsMenuButton;

    @FXML
    private GridPane lawnGrid;

    @FXML
    private void options(MouseEvent event) {
        HeaderController controller = new HeaderController();
        controller.setUser(user);
        controller.options(event);
    }

    private Tank getTank(){
        return user.getTank();
    }

    public void initialize() throws Exception {

        Wall wall = new UnbrokenWall(40, 40, 0, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 1, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 2, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 3, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 4, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 5, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 6, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 7, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 8, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 9, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 10, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 11, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 12, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 14, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 15, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 16, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 17, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 1);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 2);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 3);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 4);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 5);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 6);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 7);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 8);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 9);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 1);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 2);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 3);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 4);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 5);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 6);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 7);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 8);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 9);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 1, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 2, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 3, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 4, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 5, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 6, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 7, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 8, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 9, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 10, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 11, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 12, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 10);
        wall.makeImage(lawnGrid);

        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 2, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 3, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 4, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 6, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 7, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 8, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 10, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 11, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 12, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 10, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 11, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 12, 3);
        wall.makeImage(lawnGrid);
    }

    public void drawUser(){
        Tank tank = user.getTank();
        tank.makeImage(lawnGrid);
    }

    public void initUserActions(){
        lawnGrid.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            Tank tank = user.getTank();
            if (oldScene == null && newScene != null) {
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if(event.getCode() == KeyCode.W){
                        user.setAction(UserAction.TANK_MOVE_FORWARD);
                        tank.tankMoveForward();
                    }
                });
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if(event.getCode() == KeyCode.S){
                        user.setAction(UserAction.TANK_MOVE_BACK);
                        tank.tankMoveBack();
                    }
                });
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if(event.getCode() == KeyCode.A){
                        user.setAction(UserAction.TANK_ROTATE_LEFT);
                        double deg = tank.getRotate();
                        tank.tankRotateLeft();
                    }
                });
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if(event.getCode() == KeyCode.D){
                        user.setAction(UserAction.TANK_ROTATE_RIGHT);
                        tank.tankRotateRight();
                    }
                });
                newScene.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    user.setAction(UserAction.TANK_SHOT);
                    Shot shot = tank.tankFire();
                    shot.makeImage(lawnGrid);
                });
                newScene.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
                    user.setAction(UserAction.STATE);
                });
            }
        });
    }

    public void drawEnemy(){
        Tank tank = enemy.getTank();
        tank.makeImage(lawnGrid);
    }

    public void initEnemyActions(){
        Thread enemyThread = new Thread(() -> {
            while(true){
                if(enemy.getFlag()){
                    UserAction action = enemy.getAction();
                    switch (action){
                        case TANK_MOVE_FORWARD:
                            enemy.getTank().tankMoveForward();
                            break;
                        case TANK_MOVE_BACK:
                            enemy.getTank().tankMoveBack();
                            break;
                        case TANK_ROTATE_LEFT:
                            enemy.getTank().tankRotateLeft();
                            break;
                        case TANK_ROTATE_RIGHT:
                            enemy.getTank().tankRotateRight();
                            break;
                        case TANK_SHOT:
                            Shot shot = enemy.getTank().tankFire();
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    shot.makeImage(lawnGrid);
                                }
                            });
                            break;
                        case STATE:
                            System.out.println("I am wait");
                            break;
                    }
                }
            }
        });

        enemyThread.start();
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setEnemy(User enemy){
        this.enemy = enemy;
    }
}
