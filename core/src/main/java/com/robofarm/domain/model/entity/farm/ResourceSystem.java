package com.robofarm.domain.model.entity.farm;

public class ResourceSystem {
    private int water = 100;
    private int maxWater = 100;
    private int waterRecovery = 2;

    private int energy = 100;
    private int maxEnergy = 100;
    private int energyRecovery = 2;

    // --- Ações de Consumo e Recuperação ---

    /**
     * Tenta consumir recursos. Retorna true se houver saldo suficiente.
     */
    public boolean consume(int w, int e) {
        if (water >= w && energy >= e) {
            water -= w;
            energy -= e;
            return true;
        }
        return false;
    }

    /**
     * Recupera recursos respeitando o limite máximo (Regeneração).
     */
    public void recover() {
        water = Math.min(maxWater, water + waterRecovery);
        energy = Math.min(maxEnergy, energy + energyRecovery);
    }

    // --- Evolução e Upgrades ---

    public void upgradeMaxWater(int v) {
        maxWater += v;
        water = maxWater;
    }

    public void addWaterRecovery(int v) { waterRecovery += v; }
    public void addEnergyRecovery(int v) { energyRecovery += v; }

    // --- Getters de Estado ---

    public int getWater() { return water; }
    public int getMaxWater() { return maxWater; }
    public int getEnergy() { return energy; }
    public int getMaxEnergy() { return maxEnergy; }
}