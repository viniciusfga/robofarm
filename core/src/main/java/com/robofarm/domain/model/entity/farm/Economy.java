package com.robofarm.domain.model.entity.farm;

/**
 * Sistema de Economia da Fazenda.
 * Encapsula as regras de dinheiro e garante que o saldo nunca fique negativo.
 */
public class Economy {
    private double money;

    public boolean canAfford(double value) {
        return money >= value;
    }

    public void debit(double value) {
        if (!canAfford(value)) {
            throw new IllegalStateException("Saldo insuficiente para realizar o débito de: " + value);
        }
        money -= value;
    }

    public void credit(double value) {
        if (value < 0) throw new IllegalArgumentException("Não é possível creditar valores negativos");
        money += value;
    }

    /**
     * MÉTODO DE RESTAURAÇÃO (DDD)
     * Usado exclusivamente para reconstruir o estado a partir de persistência.
     * @param money O valor salvo anteriormente.
     */
    public void restore(double money) {
        // Aqui você pode adicionar validações de integridade do save
        if (money < 0) this.money = 0;
        else this.money = money;
    }

    public double getMoney() {
        return money;
    }
}