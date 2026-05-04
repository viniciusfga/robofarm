package com.robofarm.domain.model.entity;

public class Plantation {

    private int level;
    private double baseProduction;

    public Plantation(int level, double baseProduction) {
        this.level = level;
        this.baseProduction = baseProduction;
    }

    public int getLevel() {
        return level;
    }

    public double produce() {
        return baseProduction * level;
    }

    public void levelUp() {
        level++;
    }

    public double calculateUpgradeCost() {
        return 10 * Math.pow(1.1, level);
    }
}