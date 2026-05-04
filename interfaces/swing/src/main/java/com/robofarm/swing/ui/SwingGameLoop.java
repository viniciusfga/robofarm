package com.robofarm.swing.ui;

import javax.swing.*;

public class SwingGameLoop {

    private final java.util.function.Consumer<Double> onUpdate;
    private final Runnable onRender;
    private final int intervalMs;

    private long lastTime;

    public SwingGameLoop(java.util.function.Consumer<Double> onUpdate,
                         Runnable onRender,
                         int intervalMs) {
        this.onUpdate = onUpdate;
        this.onRender = onRender;
        this.intervalMs = intervalMs;
    }

    public void start() {
        lastTime = System.nanoTime();

        new Timer(intervalMs, e -> {
            long now = System.nanoTime();
            double deltaTime = (now - lastTime) / 1_000_000_000.0;
            lastTime = now;

            onUpdate.accept(deltaTime);
            onRender.run();

        }).start();
    }
}