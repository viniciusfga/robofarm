package com.robofarm.infrastructure.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robofarm.domain.model.entity.farm.Farm;
import com.robofarm.domain.repository.GameRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonGameRepository implements GameRepository {

    private static final String SAVE_FILE = "save.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void save(Farm farm) {
        // O Farm agora fornece seu próprio DTO para manter o encapsulamento
        GameSaveDTO dto = farm.toDTO();

        try {
            String json = gson.toJson(dto);
            Files.writeString(Path.of(SAVE_FILE), json);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar jogo", e);
        }
    }

    @Override
    public Farm load() {
        try {
            if (!Files.exists(Path.of(SAVE_FILE))) {
                return new Farm(); // Estado inicial se não houver save
            }

            String json = Files.readString(Path.of(SAVE_FILE));
            GameSaveDTO dto = gson.fromJson(json, GameSaveDTO.class);

            // Delega a reconstrução para o método estático da Entidade
            return Farm.restore(dto);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar jogo", e);
        }
    }
}