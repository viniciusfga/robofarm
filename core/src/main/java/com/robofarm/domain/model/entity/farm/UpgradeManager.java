package com.robofarm.domain.model.entity.farm;

import com.robofarm.domain.model.entity.Upgrade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpgradeManager {

    private final List<Upgrade> activeUpgrades;

    public UpgradeManager() {
        this.activeUpgrades = new ArrayList<>();
    }

    /**
     * Adiciona um upgrade à lista de adquiridos.
     */
    public void add(Upgrade upgrade) {
        activeUpgrades.add(upgrade);
    }

    /**
     * Verifica se um upgrade de determinada classe já foi adquirido.
     * Útil para evitar compras duplicadas ou requisitos de upgrades.
     */
    public boolean has(Class<? extends Upgrade> upgradeType) {
        return activeUpgrades.stream()
                .anyMatch(upgradeType::isInstance);
    }

    /**
     * Retorna uma lista imutável para proteger o estado interno.
     */
    public List<Upgrade> getActiveUpgrades() {
        return Collections.unmodifiableList(activeUpgrades);
    }
}