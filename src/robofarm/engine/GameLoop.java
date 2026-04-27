package robofarm.engine;

import robofarm.model.Fazenda;

import javax.swing.Timer;

public class GameLoop {

    private final Fazenda fazenda;
    private final Runnable aoAtualizar;
    private final Timer timer;

    public GameLoop(Fazenda fazenda, Runnable aoAtualizar) {
        this.fazenda = fazenda;
        this.aoAtualizar = aoAtualizar;

        this.timer = new Timer(1000, e -> executarTick());
    }

    private void executarTick() {
        fazenda.produzirAutomaticamente();
        fazenda.recuperarRecursos();
        aoAtualizar.run();
    }

    public void iniciar() {
        timer.start();
    }

    public void parar() {
        timer.stop();
    }
}   