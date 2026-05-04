package com.robofarm.domain.model.entity.farm;

import com.robofarm.domain.model.entity.Upgrade;
import com.robofarm.infrastructure.persistence.GameSaveDTO;

public class Farm {

    private static final int MANUAL_WATER_COST = 10;
    private static final int MANUAL_ENERGY_COST = 6;

    private Economy economy = new Economy();
    private ProductionSystem production = new ProductionSystem();
    private ResourceSystem resources = new ResourceSystem();
    private final UpgradeManager upgradeManager = new UpgradeManager();

    public Farm() {
        this.economy = new Economy();
        this.production = new ProductionSystem();
        this.resources = new ResourceSystem();
    }

    // =========================
    // AÇÕES
    // =========================

    public void irrigate() {
        if (resources.consume(MANUAL_WATER_COST, MANUAL_ENERGY_COST)) {
            production.addProduction(production.calculateClickValue());
        }
    }

    public void produceAutomatically(double deltaTime) {
        if (production.getPerSecond() > 0 && resources.consume(1, 1)) {
            production.addProduction(production.getPerSecond() * deltaTime);
        }
    }

    public void recoverResources(double deltaTime) {
        resources.recover();
    }

    public double sellAll(double pricePerKg) {
        double total = production.collectAll();
        double earned = total * pricePerKg;
        economy.credit(earned);
        return earned;
    }

    public boolean addUpgrade(Upgrade upgrade) {

        if (!economy.canAfford(upgrade.getCost())) return false;
        if (upgradeManager.has(upgrade.getClass())) return false;

        economy.debit(upgrade.getCost());
        upgradeManager.add(upgrade);

        upgrade.apply(this);

        return true;
    }

    public static Farm restore(GameSaveDTO dto) {
        Farm farm = new Farm();
        farm.economy.restore(dto.money); // A economia sabe como se restaurar
        return farm;
    }

    // Auxiliar para o save (pode ficar aqui ou em um Mapper)
    public GameSaveDTO toDTO() {
        GameSaveDTO dto = new GameSaveDTO();
        dto.money = this.economy.getMoney();
        // ... preencher os demais campos
        return dto;
    }

    // =========================
    // GETTERS
    // =========================

    public double getMoney() { return economy.getMoney(); }
    public double getProduction() { return production.getStored(); }
    public double getProductionPerSecond() { return production.getPerSecond(); }

    public int getWater() { return resources.getWater(); }
    public int getMaxWater() { return resources.getMaxWater(); }

    public int getEnergy() { return resources.getEnergy(); }
    public int getMaxEnergy() { return resources.getMaxEnergy(); }

    public boolean canAfford(double value) { return economy.canAfford(value); }
    public boolean hasUpgrade(Class<? extends Upgrade> type) { return upgradeManager.has(type); }

    // =========================
    // MODIFICAÇÕES (USADAS POR UPGRADES)
    // =========================

    public void addBaseProductionPerClick(double value) { production.addBaseClick(value); }
    public void addProductionPerSecond(double v) { production.addPerSecond(v); }

    public void increaseMaxWater(int v) { resources.upgradeMaxWater(v); }
    public void addWaterRecoveryPerTick(int v) { resources.addWaterRecovery(v); }
    public void addEnergyRecoveryPerTick(int v) { resources.addEnergyRecovery(v); }
}