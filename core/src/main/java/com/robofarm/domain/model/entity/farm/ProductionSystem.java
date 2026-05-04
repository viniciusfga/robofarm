package com.robofarm.domain.model.entity.farm;

public class ProductionSystem {
    private double storedProduction;
    private double baseProductionPerClick = 1.0;
    private double productionMultiplier = 1.0;
    private double productionPerSecond = 0;

    public void addProduction(double amount) { storedProduction += amount; }

    public double calculateClickValue() { return baseProductionPerClick * productionMultiplier; }

    public double collectAll() {
        double amount = storedProduction;
        storedProduction = 0;
        return amount;
    }

    // Getters e métodos de evolução (addBase, multiply, etc)
    public void addBaseClick(double v) { baseProductionPerClick += v; }
    public void multiply(double m) { productionMultiplier *= m; }
    public void addPerSecond(double v) { productionPerSecond += v; }
    public double getStored() { return storedProduction; }
    public double getPerSecond() { return productionPerSecond; }
}