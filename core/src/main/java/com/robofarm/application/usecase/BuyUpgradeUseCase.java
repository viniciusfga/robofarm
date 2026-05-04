package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.farm.Farm;
import com.robofarm.domain.model.entity.Upgrade;

public class BuyUpgradeUseCase {

    public boolean execute(Farm farm, Upgrade upgrade) {
        // 1. REGRA DE OURO: Se já tem, para aqui.
        // Se o retorno for false, a UI deve tratar como "Você já possui este item".
        if (farm.hasUpgrade(upgrade.getClass())) {
            System.out.println("DEBUG: Upgrade já adquirido!"); // Apenas para seu teste no console
            return false;
        }

        // 2. Requisitos técnicos (ex: nível)
        if (!upgrade.canBuy(farm)) {
            return false;
        }

        // 3. Dinheiro (Só chega aqui se não tiver o upgrade ainda)
        if (!farm.canAfford(upgrade.getCost())) {
            System.out.println("DEBUG: Dinheiro insuficiente!");
            return false;
        }

        return farm.addUpgrade(upgrade);
    }
}