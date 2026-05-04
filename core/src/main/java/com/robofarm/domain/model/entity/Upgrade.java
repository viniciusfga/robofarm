package com.robofarm.domain.model.entity;

import com.robofarm.domain.model.entity.farm.Farm;

public interface Upgrade {

    String getName();

    double getCost();

    String getDescription();

    boolean canBuy(Farm farm);

    void apply(Farm farm);
}