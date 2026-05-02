package main.java.com.robofarm.core.domain.model;

public interface Upgrade {

    String getNome();

    double getCusto();

    String getDescricao();

    boolean podeComprar(Fazenda fazenda);

    void aplicar(Fazenda fazenda);
}