package com.robofarm.domain.model.entity;

public class Player {

    private double dinheiro;
    private double producaoTotal;

    public void adicionarProducao(double valor) {
        this.producaoTotal += valor;
    }

    public double vender(double precoUnitario) {
        double ganho = producaoTotal * precoUnitario;
        dinheiro += ganho;
        producaoTotal = 0;
        return ganho;
    }

    public double getDinheiro() { return dinheiro; }
    public double getProducaoTotal() { return producaoTotal; }
}
