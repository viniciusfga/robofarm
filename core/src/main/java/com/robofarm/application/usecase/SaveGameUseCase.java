package com.robofarm.application.usecase;

import com.robofarm.domain.model.entity.farm.Farm;
import com.robofarm.domain.repository.GameRepository;

// Local: com.robofarm.application.usecase.SaveGameUseCase
public class SaveGameUseCase {
    private final GameRepository repository;

    public SaveGameUseCase(GameRepository repository) {
        this.repository = repository;
    }

    public void execute(Farm farm) {
        // Aqui você pode adicionar validações antes de salvar
        if (farm != null) {
            repository.save(farm);
            System.out.println("Progresso salvo com sucesso!");
        }
    }
}