package ru.itis.client.model.tanks.shots;

import ru.itis.client.Main;
import ru.itis.client.model.tanks.Tank;

public class PixelTankShot extends Shot {
    private static final String SHOT_PATH = Main.class.getResource("/img/shot2.png").toString();

    public PixelTankShot(int width, int height, Tank tank) {

        super(SHOT_PATH, width, height, tank);
    }
}
