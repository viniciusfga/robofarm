package com.robofarm.domain.model.entity;

import com.robofarm.domain.model.entity.farm.Farm;

public class ImprovedWateringCan implements Upgrade {

    @Override
    public String getName() {
        return "Regador Melhorado";
    }

    @Override
    public double getCost() {
        return 10.0;
    }

    @Override
    public String getDescription() {
        return "Aumenta a produção base por clique em +1 kg.";
    }

    @Override
    public boolean canBuy(Farm farm) {
        // A checagem de dinheiro agora é feita de forma delegada
        // O UseCase também já faz essa checagem, mas manter aqui
        // garante segurança se o método for chamado isoladamente.
        return farm.canAfford(getCost());
    }

    @Override
    public void apply(Farm farm) {
        // A Farm recebe a ordem e delega internamente para o ProductionSystem
        farm.addBaseProductionPerClick(1.0);
    }
}