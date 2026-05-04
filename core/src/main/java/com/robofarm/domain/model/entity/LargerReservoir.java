package com.robofarm.domain.model.entity;

import com.robofarm.domain.model.entity.farm.Farm;

public class LargerReservoir implements Upgrade {

    private double currentCost = 20.0;
    private static final double COST_MULTIPLIER = 2.0;

    @Override
    public String getName() {
        return "Reservatório maior";
    }

    @Override
    public double getCost() {
        return currentCost;
    }

    @Override
    public String getDescription() {
        return "Aumenta a capacidade máxima de água em +100 L.";
    }

    @Override
    public boolean canBuy(Farm farm) {
        return farm.getMoney() >= getCost();
    }

    @Override
    public void apply(Farm farm) {
        farm.increaseMaxWater(100);
        currentCost *= COST_MULTIPLIER;
    }
}