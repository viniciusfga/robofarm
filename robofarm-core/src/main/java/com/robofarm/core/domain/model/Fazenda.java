package main.java.com.robofarm.core.domain.model;

public class Fazenda {

    private double dinheiro;
    private double producao;

    private int agua;
    private int aguaMaxima;

    private int energia;
    private int energiaMaxima;

    private double producaoPorClique;
    private double producaoPorSegundo;

    private int consumoAguaPorClique;

    public Fazenda() {
        this.dinheiro = 0;
        this.producao = 0;

        this.agua = 100;
        this.aguaMaxima = 100;

        this.energia = 100;
        this.energiaMaxima = 100;

        this.producaoPorClique = 1;
        this.producaoPorSegundo = 0;

        this.consumoAguaPorClique = 10;
    }

    public boolean podeIrrigar() {
        return agua >= consumoAguaPorClique && energia > 0;
    }

    public boolean podeProduzirAutomaticamente() {
        return producaoPorSegundo > 0 && agua >= 1 && energia >= 1;
    }

    public void irrigarManual() {
        if (!podeIrrigar()) {
            return;
        }

        agua -= consumoAguaPorClique;
        energia -= 1;
        producao += producaoPorClique;
    }

    public void venderProducao() {
        double precoPorKg = 2.0;

        dinheiro += producao * precoPorKg;
        producao = 0;
    }

    public void produzirAutomaticamente() {
        if (!podeProduzirAutomaticamente()) {
            return;
        }

        producao += producaoPorSegundo;
        agua -= 1;
        energia -= 1;
    }

    public void recuperarRecursos() {
        if (agua < aguaMaxima) {
            agua++;
        }

        if (energia < energiaMaxima) {
            energia++;
        }
    }

    public boolean gastarDinheiro(double valor) {
        if (dinheiro < valor) {
            return false;
        }

        dinheiro -= valor;
        return true;
    }

    public void adicionarProducaoPorClique(double valor) {
        producaoPorClique += valor;
    }

    public void adicionarProducaoPorSegundo(double valor) {
        producaoPorSegundo += valor;
    }

    public void aumentarAguaMaxima(int valor) {
        aguaMaxima += valor;
        agua = aguaMaxima;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public double getProducao() {
        return producao;
    }

    public int getAgua() {
        return agua;
    }

    public int getAguaMaxima() {
        return aguaMaxima;
    }

    public int getEnergia() {
        return energia;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    public double getProducaoPorClique() {
        return producaoPorClique;
    }

    public double getProducaoPorSegundo() {
        return producaoPorSegundo;
    }
}