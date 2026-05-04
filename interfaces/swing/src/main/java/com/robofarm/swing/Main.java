package com.robofarm.swing;

import com.robofarm.swing.ui.GameWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameWindow janela = new GameWindow();
            janela.setVisible(true);
        });
    }
}