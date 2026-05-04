package com.robofarm.swing.ui;

import com.robofarm.application.usecase.*;
import com.robofarm.domain.model.entity.farm.Farm;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private final StatusPanel statusPanel;

    private final Farm farm;

    private final IrrigateUseCase irrigateUseCase;
    private final SellUseCase sellUseCase;
    private final GameTickUseCase tickUseCase;

    // Definição da cor White Smoke conforme solicitado
    private static final Color WHITE_SMOKE = new Color(255, 255, 255);

    public GameWindow() {
        this.farm = new Farm();

        this.irrigateUseCase = new IrrigateUseCase();
        this.sellUseCase = new SellUseCase();
        this.tickUseCase = new GameTickUseCase();

        setTitle("🌱 RoboFarm Idle");
        setSize(450, 600); // Aumentado levemente para acomodar os novos painéis
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuração da cor de fundo da janela principal
        getContentPane().setBackground(WHITE_SMOKE);
        setLayout(new BorderLayout());

        // Título estilizado
        JLabel title = new JLabel("RoboFarm Idle", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        // Painel Central (Status) - O StatusPanel já tem seu próprio fundo
        statusPanel = new StatusPanel();
        add(statusPanel, BorderLayout.CENTER);

        // Painel Inferior (Ações + Loja)
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false); // Torna transparente para mostrar o White Smoke

        JPanel actionsPanel = createActionsPanel();
        bottomPanel.add(actionsPanel, BorderLayout.NORTH);

        StorePanel storePanel = new StorePanel(farm, this::updateScreen);
        bottomPanel.add(storePanel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        SwingGameLoop gameLoop = new SwingGameLoop(
                deltaTime -> tickUseCase.execute(farm, deltaTime),
                this::updateScreen,
                100
        );

        gameLoop.start();
        updateScreen();
    }

    private JPanel createActionsPanel() {
        // Grid de 2 linhas conforme a imagem de referência
        JPanel panel = new JPanel(new GridLayout(2, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.setOpaque(false); // Transparência para manter a estética

        JButton irrigateButton = new JButton("Irrigar manualmente");
        JButton sellButton = new JButton("Vender produção");

        // Estilização básica dos botões para combinar com o fundo cinza
        styleActionButton(irrigateButton);
        styleActionButton(sellButton);

        irrigateButton.addActionListener(e -> {
            irrigateUseCase.execute(farm);
            updateScreen();
        });

        sellButton.addActionListener(e -> {
            sellUseCase.execute(farm);
            updateScreen();
        });

        panel.add(irrigateButton);
        panel.add(sellButton);

        return panel;
    }

    private void styleActionButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
    }

    private void updateScreen() {
        statusPanel.update(farm);
        // Opcional: storePanel.update() se precisar atualizar preços dinamicamente
    }
}