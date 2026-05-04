package com.robofarm.domain.model.entity;

public class Resource {

    private int current;
    private int max;

    private int recoveryPerTick;

    public Resource(int max, int recoveryPerTick) {
        this.max = max;
        this.current = max;
        this.recoveryPerTick = recoveryPerTick;
    }

    // =========================
    // 🔁 CORE BEHAVIOR
    // =========================

    public boolean consume(int amount) {
        if (current < amount) {
            return false;
        }
        current -= amount;
        return true;
    }

    public void recover() {
        current = Math.min(max, current + recoveryPerTick);
    }

    public void increaseMax(int value) {
        max += value;
        current = max;
    }

    public void increaseRecovery(int value) {
        recoveryPerTick += value;
    }

    // =========================
    // 📊 STATE CHECKS
    // =========================

    public boolean has(int amount) {
        return current >= amount;
    }

    // =========================
    // 📊 GETTERS
    // =========================

    public int getCurrent() {
        return current;
    }

    public int getMax() {
        return max;
    }
}