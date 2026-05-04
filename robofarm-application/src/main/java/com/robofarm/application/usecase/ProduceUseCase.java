package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.Farm;

public class ProduceUseCase {

    public void execute(Farm farm) {
        double production = farm.getPlantation().produce();

        if (farm.getWater() <= 0) return;

        farm.addProduction(production);
        farm.consumeWater(1);
    }
}