package com.appliction.game.view;

import javax.swing.JButton;
import java.awt.Font;

public class Score extends JButton {

    private int scoreValue;

    public Score(int xPosition, int yPosition, int width, int height) {
        super();
        setText(String.valueOf(scoreValue));
        setLayout(null);
        setBounds(xPosition, yPosition, width, height);
        setVisible(true);
        setFont(new Font("Arial", Font.PLAIN, 50));
    }

    public void updateScore(int newScore) {
        scoreValue = newScore;
        setText(String.valueOf(newScore));
    }

    public int getScoreValue() {
        return scoreValue;
    }
}
