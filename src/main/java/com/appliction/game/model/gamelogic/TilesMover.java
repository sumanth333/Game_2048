package com.appliction.game.model.gamelogic;

import com.appliction.game.view.GameUI;
import com.appliction.game.view.PlayArea;
import com.appliction.game.view.Tile;

import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TilesMover {
    protected int scoreOfPerformedMove;
    protected Tile[][] tiles;
    protected final int ROWS;
    protected final int COLUMNS;

    protected TilesMover() {
        tiles = PlayArea.getInstance().getTileObjects();
        ROWS = tiles.length;
        COLUMNS = tiles[0].length;
    }

    public void moveTiles(int keyCode) {
        boolean isGridChanged;
        boolean isFlipped = false;
        boolean isRotated = false;
        int[][] pastGridValues = copyGrid(tiles);


        if (keyCode == KeyEvent.VK_RIGHT) {
            //DO NOTHING
        } else if (keyCode == KeyEvent.VK_LEFT) {
            flipTheGrid(tiles);
            isFlipped = true;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            rotateTheGrid(tiles);
            isRotated = true;
        } else {
            rotateTheGrid(tiles);
            flipTheGrid(tiles);
            isRotated = true;
            isFlipped = true;
        }

        for (int i = 0; i < ROWS; ++i) {
            performTileOperations(tiles[i]);
        }

        if (isFlipped) {
            flipTheGrid(tiles);
        }
        if (isRotated) {
            rotateTheGrid(tiles);
            rotateTheGrid(tiles);
            rotateTheGrid(tiles);
        }

        isGridChanged = compareGrid(pastGridValues, tiles);
        if (isGridChanged) {
            GameAnimator.getInstance().spawnTile();
        }

        if (GameAnimator.getInstance().isGameOver()) {
            JOptionPane.showMessageDialog(GameUI.getInstance(), "*** GAME OVER ***");
        }
    }

    private boolean compareGrid(int[][] pastGridValues, Tile[][] tiles) {
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLUMNS; ++j) {
                if (pastGridValues[i][j] != tiles[i][j].getValue())
                    return true;
            }
        }
        return false;
    }

    private int[][] copyGrid(Tile[][] tiles) {
        int[][] copyTileValues = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLUMNS; ++j) {
                copyTileValues[i][j] = tiles[i][j].getValue();
            }
        }
        return copyTileValues;
    }

    private void performTileOperations(Tile[] tile) {
        slideTilesRow(tile);
        GameAnimator.getInstance().mergeTilesRow(tile);
        slideTilesRow(tile);
    }

    public void slideTilesRow(Tile[] tilesRow) {
        List<Integer> nonZeroTiles = new ArrayList<>();
        for (int i = 0; i < tilesRow.length; ++i) {
            if (tilesRow[i].getValue() > 0)
                nonZeroTiles.add(tilesRow[i].getValue());
        }
        int index = 0;
        while (index < tilesRow.length - nonZeroTiles.size()) {
            tilesRow[index++].updateValue(0);
        }
        while (!nonZeroTiles.isEmpty()) {
            tilesRow[index++].updateValue(nonZeroTiles.get(0));
            nonZeroTiles.remove(0);
        }
    }

    private void rotateTheGrid(Tile[][] tiles) {
        int[][] rotatedTilesValues = new int[tiles.length][];

        for (int rowIndex = 0; rowIndex < tiles.length; ++rowIndex) {
            rotatedTilesValues[rowIndex] = new int[tiles[0].length];
            for (int columnIndex = 0; columnIndex < tiles[0].length; ++columnIndex) {
                rotatedTilesValues[rowIndex][columnIndex] = tiles[columnIndex][rowIndex].getValue();
            }
        }

        for (int rowIndex = 0; rowIndex < tiles.length; ++rowIndex) {
            for (int columnIndex = 0; columnIndex < tiles[0].length; ++columnIndex) {
                tiles[rowIndex][columnIndex].updateValue(rotatedTilesValues[rowIndex][columnIndex]);
            }
        }
    }

    private void flipTheGrid(Tile[][] tiles) {
        int[][] reversedTiles = new int[tiles.length][];

        for (int rowIndex = 0; rowIndex < tiles.length; ++rowIndex) {
            reversedTiles[rowIndex] = new int[tiles[0].length];
            for (int columnIndex = 0; columnIndex < tiles[0].length; ++columnIndex) {
                reversedTiles[rowIndex][columnIndex] = tiles[rowIndex][tiles.length - columnIndex - 1].getValue();
            }
        }

        for (int rowIndex = 0; rowIndex < reversedTiles.length; ++rowIndex) {
            for (int columnIndex = 0; columnIndex < reversedTiles[0].length; ++columnIndex) {
                tiles[rowIndex][columnIndex].updateValue(reversedTiles[rowIndex][columnIndex]);
            }
        }
    }
}
