package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.farm.Farm;

public class SellUseCase {

    // Preço de venda definido na camada de aplicação (configuração de balanço)[cite: 6]
    private static final double PRICE = 2.0;

    public double execute(Farm farm) {
        // Limpa o estoque de produção e credita o valor na conta da fazenda[cite: 6]
        return farm.sellAll(PRICE);
    }
}