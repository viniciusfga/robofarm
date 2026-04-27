# 🌱 RoboFarm Idle

RoboFarm Idle é um jogo incremental desenvolvido em **Java + Swing**, com foco em Programação Orientada a Objetos.

O jogador administra uma fazenda automatizada, produz alimentos, vende a produção e compra upgrades para melhorar sua eficiência.

## 🎮 Mecânica principal

O jogador começa com poucos recursos:

- Dinheiro: R$ 0
- Produção: 0 kg
- Água: 100 L
- Energia: 100%

A cada ação, o jogador pode irrigar manualmente, produzir alimentos e vender a produção para comprar melhorias.

Com o tempo, a fazenda pode ser automatizada com robôs agrícolas.

## 🛠️ Tecnologias utilizadas

- Java
- Java Swing
- IntelliJ IDEA
- Git
- GitHub

## 📚 Conceitos aplicados

- Programação Orientada a Objetos
- Encapsulamento
- Interfaces
- Polimorfismo
- Separação de responsabilidades
- Eventos com `ActionListener`
- Loop de jogo com `Timer`
- Organização em pacotes
- Formatação de dados com `DecimalFormat`

## 📁 Estrutura do projeto

```text
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
        └── Formatador.java