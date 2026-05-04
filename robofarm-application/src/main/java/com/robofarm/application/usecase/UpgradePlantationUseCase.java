package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.Farm;
import com.robofarm.domain.model.entity.Plantation;

public class UpgradePlantationUseCase {

    public void execute(Farm farm) {

        Plantation plantation = farm.getPlantation();
        double cost = plantation.calculateUpgradeCost();

        if (!farm.canAfford(cost)) return;

        farm.spendMoney(cost);
        plantation.levelUp();
    }
}