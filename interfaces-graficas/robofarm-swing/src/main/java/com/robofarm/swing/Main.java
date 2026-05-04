package com.robofarm.swing;

import com.robofarm.application.usecase.GameTickUseCase;
import com.robofarm.domain.model.entity.Farm;
import com.robofarm.domain.model.entity.Plantation;
import com.robofarm.domain.model.entity.WaterResource;
import com.robofarm.swing.games.GameLoop;
import com.robofarm.swing.ui.FarmPanel;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        // ======================
        // DOMAIN
        // ======================
        WaterResource water = new WaterResource(100, 0.5);
        Plantation plantation = new Plantation(1, 1);
        Farm farm = new Farm(water, plantation);

        // ======================
        // APPLICATION
        // ======================
        GameTickUseCase gameTickUseCase = new GameTickUseCase();

        // ======================
        // UI
        // ======================
        FarmPanel panel = new FarmPanel(farm);

        JFrame frame = new JFrame("RoboFarm Idle");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        // ======================
        // GAME LOOP
        // ======================
        GameLoop loop = new GameLoop(gameTickUseCase, farm, panel::updateUI);
        loop.start();
    }
}