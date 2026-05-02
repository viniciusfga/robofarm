package main.java.com.robofarm.core.domain.model;

public class RoboIrrigador implements Upgrade {

    @Override
    public String getNome() {
        return "Robô irrigador";
    }

    @Override
    public double getCusto() {
        return 100.0;
    }

    @Override
    public String getDescricao() {
        return "Adiciona +1 kg/s de produção automática.";
    }

    @Override
    public boolean podeComprar(Fazenda fazenda) {
        return fazenda.getDinheiro() >= getCusto();
    }

    @Override
    public void aplicar(Fazenda fazenda) {
        if (fazenda.gastarDinheiro(getCusto())) {
            fazenda.adicionarProducaoPorSegundo(1);
        }
    }
}