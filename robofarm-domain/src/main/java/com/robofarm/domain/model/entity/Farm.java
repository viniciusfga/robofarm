package com.robofarm.domain.model.entity;

public class Farm {

    private double money;
    private double production;

    private WaterResource waterResource;
    private Plantation plantation;

    public Farm(WaterResource waterResource, Plantation plantation) {
        this.waterResource = waterResource;
        this.plantation = plantation;
    }

    // ======================
    // GETTERS
    // ======================

    public double getMoney() {
        return money;
    }

    public double getProduction() {
        return production;
    }

    public double getWater() {
        return waterResource.getCurrent();
    }

    public WaterResource getWaterResource() {
        return waterResource;
    }

    public Plantation getPlantation() {
        return plantation;
    }

    // ======================
    // BEHAVIOR (DOMAIN)
    // ======================
    public void produce() {

        // 1. tenta consumir água
        if (!waterResource.consume(1)) {
            return; // sem água = sem produção
        }

        // 2. calcula produção
        double amount = plantation.produce();

        // 3. acumula no estoque
        this.production += amount;
    }

    public void addProduction(double amount) {
        this.production += amount;
    }

    public void sell(double pricePerUnit) {
        this.money += production * pricePerUnit;
        this.production = 0;
    }

    public boolean consumeWater(double amount) {
        return waterResource.consume(amount);
    }

    public void addMoney(double amount) {
        this.money += amount;
    }

    public void spendMoney(double amount) {
        this.money -= amount;
    }

    public boolean canAfford(double cost) {
        return money >= cost;
    }
}