package com.robofarm.swing.ui;

import com.robofarm.application.usecase.ProduceUseCase;
import com.robofarm.domain.model.entity.Farm;

import javax.swing.*;
import java.awt.*;


public class FarmPanel extends JPanel {

    private final Farm farm;
    private ProduceUseCase produceUseCase = null;

    private final JLabel moneyLabel = new JLabel();
    private final JLabel productionLabel = new JLabel();
    private final JLabel waterLabel = new JLabel();

    public FarmPanel(Farm farm) {
        this.farm = farm;
        this.produceUseCase = produceUseCase;

        setLayout(new GridLayout(4, 1));

        add(moneyLabel);
        add(productionLabel);
        add(waterLabel);

        JButton produceButton = new JButton("Produzir");
        produceButton.addActionListener(e -> {
            produceUseCase.execute(farm);
            refresh();
        });

        add(produceButton);

        refresh();
    }

    public void refresh() {
        if (farm == null) return;

        moneyLabel.setText("Dinheiro: " + farm.getMoney());
        productionLabel.setText("Produção: " + farm.getProduction());
        waterLabel.setText("Água: " + farm.getWater());
    }
}