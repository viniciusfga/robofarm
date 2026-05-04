package com.robofarm.domain.model.entity;

import com.robofarm.domain.model.entity.farm.Farm;

public class IrrigationRobot implements Upgrade {

    @Override
    public String getName() {
        return "Robô irrigador";
    }

    @Override
    public double getCost() {
        return 100.0;
    }

    @Override
    public String getDescription() {
        return "Adiciona +1 kg/s de produção automática.";
    }

    @Override
    public boolean canBuy(Farm farm) {
        return farm.getMoney() >= getCost();
    }

    @Override
    public void apply(Farm farm) {
        farm.addProductionPerSecond(1);
    }
}