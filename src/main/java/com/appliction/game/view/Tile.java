package com.appliction.game.view;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

public class Tile extends JLabel {

    public Tile() {
        setPreferredSize(new Dimension(100, 100));
        setOpaque(true);
        setFont(new Font("Serif", Font. BOLD, 150));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setBackground(TileColor.getTileColor(1));
    }

    public void updateValue(int tileValue) {
        if(tileValue == 0) {
            this.setText("");
            tileValue = 1;
        } else {
            this.setText(String.valueOf(tileValue));
        }

        updateColor(tileValue);
    }

    public int getValue() {
        if(this.getText().isEmpty())
            return 0;

        return Integer.parseInt(this.getText());
    }

    private void updateColor(int tileValue) {
        this.setBackground(TileColor.getTileColor(tileValue));
    }
}
