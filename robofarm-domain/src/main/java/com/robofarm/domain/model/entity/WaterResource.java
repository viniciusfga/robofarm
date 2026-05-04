package com.robofarm.domain.model.entity;

public class WaterResource {

    private double current;
    private double regenRate;

    public WaterResource(double current, double regenRate) {
        this.current = current;
        this.regenRate = regenRate;
    }

    public double getCurrent() {
        return current;
    }

    public void tick() {
        current += regenRate;
    }

    public boolean consume(double amount) {
        if (current < amount) return false;
        current -= amount;
        return true;
    }
}