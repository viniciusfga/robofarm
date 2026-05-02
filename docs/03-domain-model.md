# 🌱 RoboFarm Idle — Visão do Produto

## 🎯 Proposta
**RoboFarm Idle** é um jogo incremental (*idle game*) focado em automação agrícola, onde o jogador evolui de operações manuais para uma fazenda totalmente automatizada com robôs.

O **core loop** é baseado em:
> **Produzir** → **Vender** → **Investir** → **Automatizar** → **Escalar**

---

## 🧠 Objetivo do Projeto
O projeto possui dois pilares fundamentais:

### 1. Educacional (Principal)
Explorar conceitos avançados de engenharia de software e padrões de projeto:
* **Programação Orientada a Objetos (OOP):** Polimorfismo e abstração aplicados à lógica de jogo.
* **Arquitetura:** Implementação de **Arquitetura Hexagonal** e **DDD** (Domain-Driven Design).
* **Modelagem de Domínio:** Representação fiel de processos agrícolas e automação.
* **Event-Driven Programming:** Utilização de eventos para comunicação entre camadas (Swing/Core).
* **Game Loop:** Gerenciamento de estado e tempo via `Timer`.
* **SOLID:** Foco especial em Separação de Responsabilidades (SRP) e Inversão de Dependência.

### 2. Produto (Secundário)
Criar um jogo *idle* funcional com progressão satisfatória e uma arquitetura altamente extensível para futuras engines (como LibGDX).

---

## 🎮 Gênero e Referência
* **Gênero:** Incremental / Idle Game
* **Plataforma:** Desktop (Java Swing)
* **Referência direta:** *AdVenture Capitalist*

---

## 🔁 Core Gameplay Loop
1.  **Produção manual**
2.  **Venda de recursos**
3.  **Compra de upgrades**
4.  **Automação (robôs)**
5.  **Aumento de produção**
    *(Repete o ciclo)*

---

## 📊 Estado Inicial do Jogador
| Recurso | Valor Inicial |
| :--- | :--- |
| **Dinheiro** | R$ 0,00 |
| **Produção** | 0 kg |
| **Água** | 100 L |
| **Energia** | 100% |

---

## ⚙️ Ações Disponíveis
* Irrigar manualmente.
* Produzir alimentos.
* Vender produção.
* Comprar upgrades.
* Automatizar processos (Robôs).
* Expandir capacidade da fazenda.

---

## 🧩 Diferencial do Jogo
Diferente de *idle games* genéricos, o RoboFarm Idle:
* Introduz **gestão de recursos físicos** (limitação de água e energia).
* Possui uma **simulação leve** de sistema agrícola.
* Foca na transição para **automação com robôs** (domínio técnico).
* Arquitetura pensada para **expansão modular** (IA, sensores, mapas).

---

## 🎨 Direção Visual
### Estilo
* Minimalista e Clean UI.
* Foco em legibilidade e feedback rápido ao jogador.

### Elementos
* **Paleta:** Tons de verde claro (tema agrícola).
* **Componentes:** Cards com bordas arredondadas e barras de progresso.
* **Navegação:** Layout em blocos com botões grandes e acessíveis.

---

## 🖥️ Estrutura da Interface (High-Level)
* **Header:** Nome do jogo e saldo de Dinheiro.
* **Status Bar:** Indicadores de Água, Energia e Produção Total.
* **Main Area:** Cards de plantações e controle de robôs.
* **Footer:** Menu de navegação (Plantações, Robôs, Pesquisa, Config).

---

## 📈 Escalabilidade (Visão Futura)
O design permite a evolução para:
* Sistema de múltiplas culturas (trigo, milho, soja).
* Diferentes tipos de robôs especializados.
ção com IA:** Conexão com visão computacional para análise de colheita.