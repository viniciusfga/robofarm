package main.java.com.robofarm.core.domain.model;

public class ReservatorioMaior implements Upgrade {

    @Override
    public String getNome() {
        return "Reservatório maior";
    }

    @Override
    public double getCusto() {
        return 25.0;
    }

    @Override
    public String getDescricao() {
        return "Aumenta a capacidade máxima de água em +100 L.";
    }

    @Override
    public boolean podeComprar(Fazenda fazenda) {
        return fazenda.getDinheiro() >= getCusto();
    }

    @Override
    public void aplicar(Fazenda fazenda) {
        if (fazenda.gastarDinheiro(getCusto())) {
            fazenda.aumentarAguaMaxima(100);
        }
    }
}