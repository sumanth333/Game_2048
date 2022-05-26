package com.appliction.game.view;

import java.awt.Color;
import java.util.HashMap;

public enum TileColor {
        GRAY          (new Color(204, 204, 204)),
        EMERALD       (new Color(231, 223, 134)),
        BELIZE_HOLE   (new Color(151, 206, 104)),
        CARROT        (new Color(240,  79,   3)),
        MIDNIGHT_BLUE (new Color(116, 116, 204)),
        SUNFLOWER     (new Color( 89, 188, 251)),
        ALIZARIN      (new Color(245, 213,  69)),
        WISTERIA      (new Color( 46, 204, 113)),
        SILVER        (new Color(254, 198,   6)),
        CONCRETE      (new Color(151, 206, 104)),
        ORANGE        (new Color(136, 112, 255)),
        AMETHYST      (new Color(255, 215,   0));

    private final static HashMap<Integer, TileColor> tileColorsMap = new HashMap<>();

    static {
        int exponent = 0;
        for (TileColor tileColor : values()) {
            tileColorsMap.put((int) Math.pow(2, exponent), tileColor);
            ++exponent;
        }
    }

    private final Color color;

    TileColor(Color color) {
        this.color = color;
    }

    public static Color getTileColor(int number) {
        return tileColorsMap.get(number).color;
    }
}
