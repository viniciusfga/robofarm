package com.robofarm.domain.repository;

import com.robofarm.domain.model.entity.farm.Farm;

public interface GameRepository {
    void save(Farm farm);
    Farm load();
}