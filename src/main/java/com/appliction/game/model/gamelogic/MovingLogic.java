package com.appliction.game.model.gamelogic;

import com.appliction.game.view.PlayArea;
import com.appliction.game.view.Tile;

public class MovingLogic {
    protected int scoreOfPerformedMove;
    protected final Tile[][] tiles;
    protected final int ROWS;
    protected final int COLUMNS;

    protected MovingLogic() {
        tiles = PlayArea.getInstance().getTileObjects();
        ROWS = tiles.length;
        COLUMNS = tiles[0].length;
    }

    public void moveUp() {
        for (int columnIndex = 0; columnIndex < COLUMNS; ++columnIndex) {
            for (int rowIndex = 0; rowIndex < ROWS - 1; ++rowIndex) {
                if (tiles[rowIndex][columnIndex].getValue() > 0) {
                    for (int sourceRow = rowIndex + 1; sourceRow < ROWS; ++sourceRow) {
                        if (GameLogic.getInstance().perFormMergeOperation(rowIndex, columnIndex, sourceRow, columnIndex)) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void moveDown() {
        for (int columnIndex = 0; columnIndex < COLUMNS; ++columnIndex) {
            for (int rowIndex = ROWS - 1; rowIndex > 0; --rowIndex) {
                if (tiles[rowIndex][columnIndex].getValue() > 0) {
                    for (int sourceRow = rowIndex - 1; sourceRow >= 0; --sourceRow) {
                        if (GameLogic.getInstance().perFormMergeOperation(rowIndex, columnIndex, sourceRow, columnIndex)) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void moveRight() {
        for (int rowIndex = 0; rowIndex < ROWS; ++rowIndex) {
            for (int columnIndex = COLUMNS - 1; columnIndex > 0; --columnIndex) {
                if (tiles[rowIndex][columnIndex].getValue() > 0) {
                    for (int sourceColumn = columnIndex - 1; sourceColumn >= 0; --sourceColumn) {
                        if (GameLogic.getInstance().perFormMergeOperation(rowIndex, columnIndex, rowIndex, sourceColumn)) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void moveLeft() {
        for (int rowIndex = 0; rowIndex < ROWS; ++rowIndex) {
            for (int columnIndex = 0; columnIndex < COLUMNS; ++columnIndex) {
                if (tiles[rowIndex][columnIndex].getValue() > 0) {
                    for (int sourceColumn = columnIndex + 1; sourceColumn < COLUMNS; sourceColumn++) {
                        if (GameLogic.getInstance().perFormMergeOperation(rowIndex, columnIndex, rowIndex, sourceColumn))
                            break;
                    }
                }
            }
        }
    }
}
