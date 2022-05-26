package com.appliction.game.view;

import com.appliction.game.controller.KeyBoardListener;

import javax.swing.JFrame;

public class GameUI extends JFrame {

    private static GameUI gameUI = null;
    private static int HEIGHT = 800;
    private static int WIDTH = 800;
    private static String GAME_TITLE = "Game_2048";

    private GameUI() {
    }

    private void initialiseWindow() {
        gameUI.setTitle(GAME_TITLE);
        gameUI.setResizable(false);
        gameUI.setVisible(true);
        gameUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameUI.setAlwaysOnTop(true);
        gameUI.setSize(WIDTH, HEIGHT);
        gameUI.addKeyListener(KeyBoardListener.getInstance());
    }

    public static GameUI getInstance() {
        if (gameUI == null) {
            gameUI = new GameUI();
            gameUI.initialiseWindow();
        }
        return gameUI;
    }
}
