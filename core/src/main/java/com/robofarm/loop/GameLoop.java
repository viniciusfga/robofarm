package com.robofarm.loop;

import javax.swing.Timer;

public class GameLoop {

    private final Runnable tick;
    private final Runnable render;
    private final int delay;

    private Timer timer;

    public GameLoop(Runnable tick, Runnable render, int delay) {
        this.tick = tick;
        this.render = render;
        this.delay = delay;
    }

    public void start() {
        timer = new Timer(delay, e -> {
            tick.run();
            render.run();
        });
        timer.start();
    }

    public void stop() {
        if (timer != null) {
            timer.stop();
        }
    }
}