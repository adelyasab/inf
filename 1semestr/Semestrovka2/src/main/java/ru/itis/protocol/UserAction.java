package ru.itis.protocol;

import java.util.HashMap;
import java.util.Map;

public enum UserAction {
    EXIT(1),
    BATTLE_SEARCH(2),
    INTRO_MENU(3),
    IN_THE_BATTLE(4),
    TANK_MOVE_FORWARD(5),
    TANK_MOVE_BACK(6),
    TANK_ROTATE_LEFT(7),
    TANK_ROTATE_RIGHT(8),
    TANK_SHOT(9),
    STATE(10);

    private int b;

    UserAction(int b) {
        this.b = b;
    }

    public byte getByte() {
        return (byte) b;
    }

    private static final Map<Byte, UserAction> nameMap;

    static {

        nameMap = new HashMap<>(UserAction.values().length);
        for (UserAction mt : UserAction.values()) {
            nameMap.put(mt.getByte(), mt);
        }
    }

    public static UserAction getMessageType(byte value) {
        return nameMap.get(value);
    }
}
