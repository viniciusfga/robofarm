package com.robofarm.swing.ui;

import com.robofarm.application.usecase.BuyUpgradeUseCase;
import com.robofarm.domain.model.entity.*;
import com.robofarm.domain.model.entity.farm.Farm;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StorePanel extends JPanel {

    private final Farm farm;
    private final Runnable onBuy;
    private final List<Upgrade> upgrades;

    private final BuyUpgradeUseCase buyUpgradeUseCase;

    public StorePanel(Farm farm, Runnable onBuy) {
        this.farm = farm;
        this.onBuy = onBuy;

        this.buyUpgradeUseCase = new BuyUpgradeUseCase();

        this.upgrades = List.of(
                new ImprovedWateringCan(),
                new LargerReservoir(),
                new IrrigationRobot()
        );

        setLayout(new GridLayout(upgrades.size(), 1, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Upgrades"));

        buildButtons();
    }

    private void buildButtons() {
        for (Upgrade upgrade : upgrades) {
            JButton button = createUpgradeButton(upgrade);
            add(button);
        }
    }

    private JButton createUpgradeButton(Upgrade upgrade) {
        JButton button = new JButton(
                upgrade.getName() + " - R$ " + upgrade.getCost()
        );

        button.setToolTipText(upgrade.getDescription());

        button.addActionListener(e -> {

            boolean success = buyUpgradeUseCase.execute(farm, upgrade);

            if (success) {
                onBuy.run();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Dinheiro insuficiente para comprar: " + upgrade.getName()
                );
            }
        });

        return button;
    }
}