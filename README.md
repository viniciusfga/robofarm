# 🌱 RoboFarm Idle

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-red?style=for-the-badge&logo=openjdk">
  <img src="https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge">
</p>

<p align="center">
  <strong>Um jogo incremental em Java + Swing sobre automação agrícola, robôs e gerenciamento de recursos.</strong>
</p>

<p align="center">
  🌾 Produza • 💧 Irrigue • 🤖 Automatize • 💰 Venda • 🚜 Expanda
</p>


## 📌 Sobre o projeto

**RoboFarm Idle** é um jogo incremental no estilo *idle game*, desenvolvido em **Java com Swing**, no qual o jogador administra uma fazenda automatizada.

O jogador começa com poucos recursos e precisa produzir alimentos manualmente, vender a produção e investir em melhorias para automatizar a fazenda com robôs agrícolas.

O projeto foi criado com foco em estudo de:

- Programação Orientada a Objetos
- Interfaces
- Polimorfismo
- Organização em pacotes
- Eventos gráficos com Swing
- Loop de jogo com `Timer`
- Separação de responsabilidades

## 🎮 Gameplay

O jogador inicia com:

| Recurso | Valor inicial |
|---|---:|
| Dinheiro | R$ 0,00 |
| Produção | 0 kg |
| Água | 100 L |
| Energia | 100% |

A partir disso, pode:

- Irrigar manualmente
- Produzir alimentos
- Vender a produção
- Comprar upgrades
- Automatizar a produção
- Expandir a capacidade da fazenda


## 🖼️ Interface inicial

```text
🌱 RoboFarm Idle

Dinheiro: R$ 0,00
Produção: 0 kg
Água: 100 / 100 L
Energia: 100 / 100%
Produção automática: 0 kg/s

[ Irrigar manualmente ]
[ Vender produção ]

Upgrades:
[ Regador melhorado - R$ 10 ]
[ Reservatório maior - R$ 25 ]
[ Robô irrigador - R$ 100 ]
[ Trator autônomo - R$ 250 ]
