package robofarm.view.components;

import robofarm.model.Fazenda;
import robofarm.util.Formatador;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private final JLabel lblDinheiro;
    private final JLabel lblProducao;
    private final JLabel lblAgua;
    private final JLabel lblEnergia;
    private final JLabel lblProducaoSegundo;

    public StatusPanel() {
        setLayout(new GridLayout(5, 1, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        lblDinheiro = new JLabel();
        lblProducao = new JLabel();
        lblAgua = new JLabel();
        lblEnergia = new JLabel();
        lblProducaoSegundo = new JLabel();

        add(lblDinheiro);
        add(lblProducao);
        add(lblAgua);
        add(lblEnergia);
        add(lblProducaoSegundo);
    }

    public void atualizar(Fazenda fazenda) {
        lblDinheiro.setText("Dinheiro: " + Formatador.formatarDinheiro(fazenda.getDinheiro()));
        lblProducao.setText("Produção: " + Formatador.formatarKg(fazenda.getProducao()));
        lblAgua.setText("Água: " + fazenda.getAgua() + " / " + fazenda.getAguaMaxima() + " L");
        lblEnergia.setText("Energia: " + fazenda.getEnergia() + " / " + fazenda.getEnergiaMaxima() + "%");
        lblProducaoSegundo.setText("Produção automática: " + Formatador.formatarKg(fazenda.getProducaoPorSegundo()) + "/s");
    }
}