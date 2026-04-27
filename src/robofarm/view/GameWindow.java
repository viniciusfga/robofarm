package robofarm.view;

import robofarm.engine.GameLoop;
import robofarm.model.Fazenda;
import robofarm.view.components.LojaPanel;
import robofarm.view.components.StatusPanel;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private final Fazenda fazenda;
    private final StatusPanel statusPanel;
    private final LojaPanel lojaPanel;
    private final GameLoop gameLoop;

    public GameWindow() {
        this.fazenda = new Fazenda();

        setTitle("🌱 RoboFarm Idle");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("🌱 RoboFarm Idle", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        add(titulo, BorderLayout.NORTH);

        statusPanel = new StatusPanel();
        add(statusPanel, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new BorderLayout());

        JPanel painelAcoes = criarPainelAcoes();
        painelInferior.add(painelAcoes, BorderLayout.NORTH);

        lojaPanel = new LojaPanel(fazenda, this::atualizarTela);
        painelInferior.add(lojaPanel, BorderLayout.CENTER);

        add(painelInferior, BorderLayout.SOUTH);

        gameLoop = new GameLoop(fazenda, this::atualizarTela);
        gameLoop.iniciar();

        atualizarTela();
    }

    private JPanel criarPainelAcoes() {
        JPanel painel = new JPanel(new GridLayout(2, 1, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton btnIrrigar = new JButton("Irrigar manualmente");
        JButton btnVender = new JButton("Vender produção");

        btnIrrigar.addActionListener(e -> {
            fazenda.irrigarManual();
            atualizarTela();
        });

        btnVender.addActionListener(e -> {
            fazenda.venderProducao();
            atualizarTela();
        });

        painel.add(btnIrrigar);
        painel.add(btnVender);

        return painel;
    }

    private void atualizarTela() {
        statusPanel.atualizar(fazenda);
    }
}