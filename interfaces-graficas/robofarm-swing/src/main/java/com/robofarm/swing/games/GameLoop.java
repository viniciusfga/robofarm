package com.robofarm.swing.games;

import com.robofarm.application.usecase.GameTickUseCase;
import com.robofarm.domain.model.entity.Farm;

import javax.swing.Timer;

public class GameLoop {

    private final GameTickUseCase useCase;
    private final Farm farm;
    private final Runnable uiCallback;
    private Timer timer;

    public GameLoop(GameTickUseCase useCase, Farm farm, Runnable uiCallback) {
        this.useCase = useCase;
        this.farm = farm;
        this.uiCallback = uiCallback;
    }

    public void start() {
        timer = new Timer(100, e -> tick());
        timer.start();
    }

    private void tick() {
        useCase.execute(farm);
        uiCallback.run();
    }
}