package main.java.com.robofarm.core.domain.model;

public class RegadorMelhorado implements Upgrade {

    @Override
    public String getNome() {
        return "Regador melhorado";
    }

    @Override
    public double getCusto() {
        return 10.0;
    }

    @Override
    public String getDescricao() {
        return "Aumenta a produção manual em +1 kg por clique.";
    }

    @Override
    public boolean podeComprar(Fazenda fazenda) {
        return fazenda.getDinheiro() >= getCusto();
    }

    @Override
    public void aplicar(Fazenda fazenda) {
        if (fazenda.gastarDinheiro(getCusto())) {
            fazenda.adicionarProducaoPorClique(1);
        }
    }
}