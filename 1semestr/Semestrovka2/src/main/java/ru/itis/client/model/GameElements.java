package ru.itis.client.model;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public abstract class GameElements implements Serializable {
    protected String path;
    transient protected ImageView img;
    protected int width;
    protected int height;

    public GameElements(String path, int width, int height) {
        this.path = path;
        this.width = width;
        this.height = height;
    }

}
