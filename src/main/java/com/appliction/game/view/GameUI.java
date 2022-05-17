package com.appliction.game.view;

import javax.swing.JFrame;

public class GameUI extends JFrame {

    private static GameUI gameUI = null;

    private GameUI() {}

    private void initiateWindow() {
        gameUI.setTitle("Game_2048");
        gameUI.setResizable(false);
        gameUI.pack();
        gameUI.setVisible(true);
        gameUI.setLocationRelativeTo(null);
        gameUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameUI.setAlwaysOnTop(true);
        gameUI.setSize(800,800);
    }

    public static GameUI getInstance() {
        if (gameUI == null) {
            gameUI = new GameUI();
            gameUI.initiateWindow();
        }
        return gameUI;
    }
}
