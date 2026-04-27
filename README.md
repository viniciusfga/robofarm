# 🌱 RoboFarm Idle

RoboFarm Idle é um jogo incremental desenvolvido em **Java + Swing**, no qual o jogador administra uma pequena fazenda automatizada por robôs agrícolas.

O jogador começa irrigando manualmente, produzindo alimentos, vendendo a produção e comprando upgrades para melhorar a eficiência da fazenda.

---

## 🎮 Sobre o jogo

No início do jogo, o jogador possui:

- Dinheiro: R$ 0
- Produção: 0 kg
- Água: 100 L
- Energia: 100%

A principal mecânica consiste em produzir alimentos por meio da irrigação, vender a produção e investir em melhorias.

Com o avanço do jogo, o jogador pode desbloquear automações como robôs irrigadores e tratores autônomos.

---

## 🧠 Objetivo do projeto

Este projeto tem como objetivo praticar conceitos fundamentais de desenvolvimento em Java, incluindo:

- Programação Orientada a Objetos
- Encapsulamento
- Interfaces gráficas com Swing
- Eventos com `ActionListener`
- Atualização de interface com `JLabel`
- Loop de jogo com `Timer`
- Controle de estado do jogo
- Organização em pacotes

---

## 🛠️ Tecnologias utilizadas

- Java
- Java Swing
- IntelliJ IDEA
- Git e GitHub

---

## 📁 Estrutura do projeto

```text
robofarm/
docs/
└──RoboFarm.mmd
src/
└── robofarm/
    ├── Main.java
    ├── engine/
    │   └── GameLoop.java
    ├── model/
    │   ├── Fazenda.java
    │   ├── Upgrade.java
    │   ├── RegadorMelhorado.java
    │   ├── ReservatorioMaior.java
    │   ├── RoboIrrigador.java
    │   └── TratorAutonomo.java
    ├── view/
    │   ├── GameWindow.java
    │   └── components/
    │       ├── StatusPanel.java
    │       └── LojaPanel.java
    └── util/
        └── Formatador.javaw.java