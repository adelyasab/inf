package ru.itis.client.model.tanks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import ru.itis.client.model.GameElements;
import ru.itis.client.model.tanks.shots.PixelTankShot;
import ru.itis.client.model.tanks.shots.Shot;

public abstract class Tank extends GameElements {
    protected int col;
    protected int row;
    protected double damage;
    protected int hp;
    protected double shotSpeed;
    protected double speed;

    public Tank(String path, int width, int height, int col, int row, double damage, int hp, double shotSpeed, double speed) {
        super(path, width, height);
        this.col = col;
        this.row = row;
        this.damage = damage;
        this.hp = hp;
        this.shotSpeed = shotSpeed;
        this.speed = speed;
    }

    public void makeImage(GridPane lawn){
        img = new ImageView();
        Image im = new Image(path, width, height,false,false);
        img.setImage(im);
        lawn.add(img, col, row,1,1);
    }

    public void tankMoveForward()
    {
        double rotate = img.getRotate();
        img.setTranslateX(img.getTranslateX() + Math.sin(Math.toRadians(rotate)) * this.getSpeed());
        img.setTranslateY(img.getTranslateY() - Math.cos(Math.toRadians(rotate)) * this.getSpeed());
    }

    public void tankMoveBack(){
        double rotate = img.getRotate();
        img.setTranslateX(img.getTranslateX() + Math.sin(Math.toRadians(rotate)) * (-this.getSpeed()));
        img.setTranslateY(img.getTranslateY() - Math.cos(Math.toRadians(rotate)) * (-this.getSpeed()));
    }

    public void tankRotateLeft(){
        img.setRotate(img.getRotate() - 1);
    }

    public void tankRotateRight(){
        img.setRotate(img.getRotate() + 1);
    }

    public Shot tankFire(){
        return new PixelTankShot(10, 10, this);
    }

    public double getCenterX(){
        return img.getLayoutX() + img.getTranslateX() - 5 + 15 - 5; // Некий отсуп(хз чо это), в центр и минус половина ширины
    }

    public double getCenterY(){
        return img.getLayoutY() + img.getTranslateY() - 15 + 5; // в центр и минус половина ширины
    }

    public double getX(){
        double rotate = img.getRotate();
        return getCenterX() + Math.sin(Math.toRadians(rotate)) * 30;
    }

    public double getY(){
        double rotate = img.getRotate();
        return getCenterY() - Math.cos(Math.toRadians(rotate)) * 30;
    }

    public double getRotate(){
        return img.getRotate();
    }

    public double getShotSpeed() {
        return shotSpeed;
    }

    public double getSpeed() {
        return speed;
    }
}
