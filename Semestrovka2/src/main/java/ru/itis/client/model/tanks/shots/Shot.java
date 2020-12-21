package ru.itis.client.model.tanks.shots;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import ru.itis.client.model.GameElements;
import ru.itis.client.model.tanks.Tank;

public abstract class Shot extends GameElements {
    protected int col;
    protected int row;
    protected Timeline shotAnimation;
    protected Tank tank;
    protected double rotate;

    public Shot(String path, int width, int height, Tank tank) {
        super(path, width, height);
        this.col = 0;
        this.row = 0;
        this.tank = tank;
        this.rotate = tank.getRotate();
    }

    public void makeImage(GridPane lawn) {
        img = new ImageView();
        Image im = new Image(path, width, height, false, false);
        img.setImage(im);
        img.setTranslateX(tank.getX());
        img.setTranslateY(tank.getY());
        img.setRotate(tank.getRotate());
        lawn.add(img, col, row);
        shotFlight();
    }

    private void shotFlight() {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(70), e -> shotWalk()));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        this.shotAnimation = animation;
    }

    private void shotWalk() {
        img.setTranslateX(img.getTranslateX() + Math.sin(Math.toRadians(rotate)) * tank.getShotSpeed());
        img.setTranslateY(img.getTranslateY() - Math.cos(Math.toRadians(rotate)) * tank.getShotSpeed());
    }
}
