package com.robofarm.swing.ui;

import com.robofarm.domain.model.entity.farm.Farm;
import com.robofarm.swing.ui.util.Formatter;

import javax.swing.*;
import java.awt.*;

/**
 * Painel de Status fiel à imagem image_55a2c6.png.
 * Renderiza o estado da Farm delegando o acesso aos dados para o Agregado Raiz.
 */
public class StatusPanel extends JPanel {

    private final JLabel lblDinheiro;
    private final JLabel lblProducao;
    private final JLabel lblAgua;
    private final JLabel lblEnergia;
    private final JLabel lblProducaoSegundo;

    public StatusPanel() {
        // Configura o layout de grade com 5 linhas (uma para cada recurso da imagem)
        setLayout(new GridLayout(5, 1, 10, 10));

        // Borda com título "Status da Fazenda" conforme image_55a2c6.png
        setBorder(BorderFactory.createTitledBorder("Status da Fazenda"));

        // Cor de fundo leve para destacar o painel central
        setBackground(new Color(255, 255, 255));

        // Inicialização dos labels com as cores extraídas da imagem[cite: 1]
        lblDinheiro = createStyledLabel(new Color(46, 204, 113)); // Verde (Dinheiro)
        lblProducao = createStyledLabel(new Color(230, 126, 34)); // Laranja (Estoque)
        lblAgua = createStyledLabel(new Color(52, 152, 219));     // Azul (Água)
        lblEnergia = createStyledLabel(new Color(241, 196, 15));  // Amarelo (Energia)
        lblProducaoSegundo = createStyledLabel(new Color(52, 73, 94)); // Cinza Escuro (Automação)

        add(lblDinheiro);
        add(lblProducao);
        add(lblAgua);
        add(lblEnergia);
        add(lblProducaoSegundo);
    }

    /**
     * Cria um JLabel estilizado para manter a consistência visual da UI[cite: 1].
     */
    private JLabel createStyledLabel(Color color) {
        JLabel label = new JLabel();
        label.setFont(new Font("SansSerif", Font.BOLD, 16)); // Fonte em negrito conforme imagem
        label.setForeground(color);
        // Padding lateral para os ícones não encostarem na borda
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        return label;
    }

    /**
     * Atualiza os textos baseando-se no estado atual da Farm[cite: 1].
     * Respeita o encapsulamento: a UI não conhece os subsistemas, apenas a Farm[cite: 1].
     */
    public void update(Farm farm) {
        // Formatação fiel aos labels da imagem image_55a2c6.png[cite: 1]
        lblDinheiro.setText("💰 Dinheiro: " + Formatter.formatMoney(farm.getMoney()));

        lblProducao.setText("📦 Estoque: " + Formatter.formatKg(farm.getProduction()));

        lblAgua.setText(String.format("💧 Água: %d / %d L",
                farm.getWater(),
                farm.getMaxWater()));

        lblEnergia.setText(String.format("⚡ Energia: %d / %d%%",
                farm.getEnergy(),
                farm.getMaxEnergy()));

        lblProducaoSegundo.setText("🤖 Automação: " + Formatter.formatKg(farm.getProductionPerSecond()) + "/s");
    }
}