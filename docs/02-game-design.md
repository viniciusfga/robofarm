# 🎮 Game Design — RoboFarm Idle

## 🎯 Objetivo deste Documento
Definir formalmente os pilares que sustentam a jogabilidade e a lógica do sistema:
*   **Mecânicas do jogo**
*   **Sistemas de progressão**
*   **Fórmulas matemáticas**
*   **Balanceamento inicial**
*   **Estrutura de upgrades e automação**

Este documento serve como a especificação técnica para implementação e posterior *tuning* de valores.

---

## 🔁 Core Loop (Formalizado)
> **Produção** → **Armazenamento** → **Venda** → **Dinheiro** → **Upgrade** → **Automação** → **Produção++**

---

## 🌾 Sistema de Produção
Cada plantação é tratada como uma unidade produtiva independente dentro do domínio do jogo.

### 📦 Entidade: Plantação
| Atributo | Descrição |
| :--- | :--- |
| **Tipo** | Identificador da cultura (Ex: Milho, Soja). |
| **Nível** | Inteiro que representa a evolução daquela plantação. |
| **Produção Base** | Valor fixo de produção por segundo no nível 1. |
| **Multiplicador** | Bônus acumulado de upgrades e automação. |
| **Automatizada** | Valor booleano que indica se a produção é contínua. |

### ⚙️ Fórmula de Produção
A produção por segundo ($P$) é calculada como:
$$P = B \cdot L \cdot M$$

Onde:
*   $P$ = Produção final por segundo.
*   $B$ = Produção base da cultura.
*   $L$ = Nível atual da plantação.
*   $M$ = Multiplicador total (proveniente de upgrades e bônus de automação).

### 📈 Crescimento de Produção
1.  **Crescimento Linear:** Ocorre através do aumento do nível ($L$).
2.  **Crescimento Exponencial:** Ocorre através da aquisição de upgrades de multiplicador ($M$).

---

## 💰 Sistema de Venda
A produção acumulada no estoque é convertida em capital para reinvestimento.

### ⚙️ Fórmula de Venda
$$D = P \cdot V$$

Onde:
*   $D$ = Dinheiro gerado por segundo (ou por clique de venda).
*   $P$ = Quantidade de produção atual vendida.
*   $V$ = Valor de mercado por kg da cultura.

### 📊 Valores Iniciais Sugeridos
| Cultura | Valor por kg |
| :--- | :--- |
| **Milho** | R$ 2,00 |
| **Soja** | R$ 2,50 |

---

## 💧 Sistema de Recursos
Diferente de outros *idle games*, o RoboFarm impõe limites físicos de sustentabilidade.

### Água
*   **Consumo:** Proporcional à taxa de produção.
*   **Regeneração:** Taxa passiva constante.
    $$A_{t+1} = A_t + R - C$$

Onde:
*   $R$ = Taxa de regeneração (L/s).
*   $C$ = Consumo por produção ativa (L/s).

### ⚡ Energia
*   **Requisito:** Necessária para manter os robôs ativos.
*   **Impacto:** Se a energia chegar a 0, a automação é interrompida, retornando ao estado manual.

---

## 🤖 Sistema de Automação
A automação remove a necessidade de cliques repetitivos e otimiza a eficiência operacional.

### Estados de Produção
| Estado | Comportamento |
| :--- | :--- |
| **Manual** | Produção ocorre apenas mediante clique do usuário. |
| **Semi-auto** | Produção ocorre sozinha, mas com um *cooldown* elevado. |
| **Automático** | Produção contínua baseada no Game Tick. |

### ⚙️ Multiplicador de Automação
$$M = 1 + a$$
Onde $a$ representa o bônus de eficiência tecnológica (ex: $a = 0.5$ gera um bônus de $+50\%$).

---

## 🧱 Sistema de Upgrades
Os upgrades são divididos em quatro categorias principais:
1.  **Produção:** Aumenta o valor de $B$ ou o multiplicador $M$.
2.  **Eficiência:** Reduz o consumo de água ($C$) ou energia por ciclo.
3.  **Automação:** Desbloqueia ou melhora os robôs.
4.  **Capacidade:** Aumenta os limites máximos dos tanques de água e baterias.

### 📈 Custo de Upgrade (Escalonamento Exponencial)
Para evitar que o jogador zere o jogo rapidamente, o custo ($C$) cresce conforme o nível ($L$):
$$C = C_0 \cdot r^L$$

Onde:
*   $C_0$ = Custo inicial do upgrade.
*   $r$ = Taxa de crescimento (Sugestão: $1.10$ a $1.20$).
*   $L$ = Nível atual do upgrade.

---

## 📊 Fases de Progressão
*   **Early Game (0–10 min):** Foco em produção manual e primeiros upgrades de Milho.
*   **Mid Game (10–60 min):** Desbloqueio da Soja e primeira automação básica. Gestão de água torna-se relevante.
*   **Late Game (1h+):** Produção massiva, dependência total de robôs e foco em otimização de custos de energia.

---

## 🔄 Loop de Atualização (Game Tick)
A lógica deve ser processada em um `Timer` (no Swing) ou `render()` (no LibGDX) a cada **100ms**:
1.  Calcular nova produção baseada no tempo decorrido.
2.  Verificar disponibilidade de água/energia.
3.  Deduzir consumo e adicionar regeneração.
4.  Atualizar saldo de produção e dinheiro.
5.  Refletir mudanças na interface do usuário (UI).

---

## ⚠️ Regras Críticas de Design
*   **Falta de Água:** Produção reduzida drasticamente (ou zerada).
*   **Falta de Energia:** Desativação imediata dos robôs (automação).
*   **Limites:** Recursos não podem exceder a capacidade máxima (Overflow).
*   **Economia:** O custo de expansão deve sempre crescer mais rápido que a produção para manter o desafio.