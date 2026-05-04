package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.Farm;

public class SellUseCase {

    private static final double PRICE = 2.0;

    public void execute(Farm farm) {
        farm.sell(PRICE);
    }
}