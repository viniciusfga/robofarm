package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.farm.Farm;

public class IrrigateUseCase {

    public void execute(Farm farm) {
        // Delega para a Farm validar recursos e adicionar produção manual[cite: 5]
        farm.irrigate();
    }
}