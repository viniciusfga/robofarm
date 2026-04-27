package robofarm;

import robofarm.view.GameWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameWindow janela = new GameWindow();
            janela.setVisible(true);
        });
    }
}