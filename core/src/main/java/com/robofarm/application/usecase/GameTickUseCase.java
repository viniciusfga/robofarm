package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.farm.Farm;

public class GameTickUseCase {

    public void execute(Farm farm, double deltaTime) {

        farm.produceAutomatically(deltaTime);
        farm.recoverResources(deltaTime);

    }
}