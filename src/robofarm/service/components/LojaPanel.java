package robofarm.view.components;

import robofarm.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LojaPanel extends JPanel {

    private final Fazenda fazenda;
    private final Runnable aoComprar;
    private final List<Upgrade> upgrades;

    public LojaPanel(Fazenda fazenda, Runnable aoComprar) {
        this.fazenda = fazenda;
        this.aoComprar = aoComprar;

        this.upgrades = List.of(
                new RegadorMelhorado(),
                new ReservatorioMaior(),
                new RoboIrrigador()
        );

        setLayout(new GridLayout(upgrades.size(), 1, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Upgrades"));

        montarBotoes();
    }

    private void montarBotoes() {
        for (Upgrade upgrade : upgrades) {
            JButton botao = criarBotaoUpgrade(upgrade);
            add(botao);
        }
    }

    private JButton criarBotaoUpgrade(Upgrade upgrade) {
        JButton botao = new JButton(upgrade.getNome() + " - R$ " + upgrade.getCusto());

        botao.setToolTipText(upgrade.getDescricao());

        botao.addActionListener(e -> {
            if (upgrade.podeComprar(fazenda)) {
                upgrade.aplicar(fazenda);
                aoComprar.run();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Dinheiro insuficiente para comprar: " + upgrade.getNome()
                );
            }
        });

        return botao;
    }
}