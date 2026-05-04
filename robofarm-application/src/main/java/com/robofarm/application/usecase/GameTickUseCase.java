package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.Farm;

public class GameTickUseCase {

    public void execute(Farm farm) {
        // 1. produção automática
        farm.produce();

        // 2. regeneração de recursos
        farm.getWaterResource().tick();

        // (futuro)
        // farm.consumeEnergy();
        // farm.applyAutomation();
    }
}