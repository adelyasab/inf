package ru.itis.client.model.tanks;

import ru.itis.client.Main;

public class PixelTank extends Tank {
    private static final String TANK_PATH = Main.class.getResource("/img/tank.png").toString();
    private static final double DAMAGE = 5;
    private static final int HP = 50;
    private static final double SHOT_SPEED = 5;
    private static final double SPEED = 2;

    public PixelTank(int width, int height, int col, int row) {
        super(TANK_PATH, width, height, col, row, DAMAGE, HP, SHOT_SPEED, SPEED);
    }
}
