package ru.itis.client.model;


import ru.itis.client.model.tanks.PixelTank;
import ru.itis.client.model.tanks.Tank;
import ru.itis.protocol.UserAction;

import java.io.Serializable;

public class User implements Serializable {
    protected Tank tank;
    protected volatile UserAction action;
    private volatile Boolean flag;
    private int userId;

    public User(int id) {
        this.userId = id;
        this.flag = false;
        this.tank = new PixelTank(30, 30, 6, 6);
    }

    public User(int id, UserAction action) {
        this.userId = id;
        this.flag = false;
        this.tank = new PixelTank(30, 30, 6, 6);
        this.action = action;
    }

    public User(Tank tank, UserAction action, Boolean flag) {
        this.tank = tank;
        this.action = action;
        this.flag = flag;
    }

    public void setAction(UserAction action) {
        flag = true;
        this.action = action;
    }

    public UserAction getAction() {
        this.flag = false;
        return this.action;
    }

    public Boolean getFlag() {
        return flag;
    }

    public Tank getTank() {
        return this.tank;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return user.getUserId() == this.getUserId();
    }
}
