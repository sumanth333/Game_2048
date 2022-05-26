package com.appliction.game.view;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Color;

public class PlayArea extends JPanel {

    private static PlayArea playArea = null;
    private static final int ROWS = 4;
    private static final int COLUMNS = 4;
    private Tile[][] tileObjects = new Tile[ROWS][COLUMNS];

    private PlayArea() {
        setLayout(new GridLayout(ROWS, COLUMNS));
    }

    public static PlayArea getInstance() {
        if (playArea == null) {
            playArea = new PlayArea();
            playArea.addTileObjects();
            GameUI.getInstance().add(playArea);
        }
        return playArea;
    }

    private void addTileObjects() {
        playArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int rowIndex = 0; rowIndex < ROWS; rowIndex++) {
            for (int columnIndex = 0; columnIndex < COLUMNS; ++columnIndex) {
                Tile tile = new Tile();
                tileObjects[rowIndex][columnIndex] = tile;
                playArea.add(tile);
            }
        }
    }

    public Tile[][] getTileObjects() {
        return tileObjects;
    }
}
