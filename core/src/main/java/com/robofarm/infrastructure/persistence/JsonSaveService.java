package com.robofarm.infrastructure.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robofarm.domain.model.entity.farm.Farm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonSaveService {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static final String FILE_PATH = "savegame.json";

    public void salvar(Farm farm) {

        GameSave save = toDTO(farm);

        try {
            String json = gson.toJson(save);
            Files.writeString(Path.of(FILE_PATH), json);

            System.out.println("Progresso salvo em: " + FILE_PATH);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar jogo", e);
        }
    }

    // =========================
    // MAPEAMENTO
    // =========================

    private GameSave toDTO(Farm farm) {
        GameSave save = new GameSave();

        save.money = farm.getMoney();
        save.production = farm.getProduction();
        save.productionPerSecond = farm.getProductionPerSecond();

        save.water = farm.getWater();
        save.maxWater = farm.getMaxWater();

        save.energy = farm.getEnergy();
        save.maxEnergy = farm.getMaxEnergy();

        return save;
    }
}