# 📄 04 — Use Cases (RoboFarm Idle)

## 🎯 Objetivo
Descrever formalmente as interações entre o ator (jogador) e o sistema, alinhadas ao *core loop*:
**Produzir → Vender → Investir → Automatizar → Escalar**

## 👤 Ator Principal
* **Jogador:** Interage com o sistema via UI (Swing). Toma decisões estratégicas e operacionais.

---

## 📚 Lista de Casos de Uso

### UC-01 — Produzir Recursos Manualmente
**Descrição:** Permite ao jogador gerar produção de forma manual (clique).
* **Fluxo Principal:**
    1. Jogador aciona ação de produção (ex: botão “Produzir”).
    2. Sistema calcula produção com base na plantação.
    3. Sistema consome água proporcional.
    4. Produção é adicionada ao estoque.
* **Regras de Negócio:**
    * Produção depende do Nível da plantação e Produção base.
    * Se **água = 0** → produção é bloqueada.

### UC-02 — Produção Automática
**Descrição:** Executa produção contínua via robôs.
* **Fluxo Principal:**
    1. Sistema executa *Game Tick* (100ms).
    2. Verifica energia disponível.
    3. Calcula produção automática.
    4. Atualiza estoque.
* **Regras de Negócio:**
    * Depende do estado: Manual / Semi-auto / Automático.
    * Se **energia = 0** → automação é desativada.

### UC-03 — Gerenciar Recursos (Água e Energia)
**Descrição:** Sistema mantém consistência dos recursos físicos.
* **Fluxo Principal:**
    1. Sistema calcula: Consumo (produção ativa) e Regeneração (passiva).
    2. Atualiza valores no próximo tick.
* **Regras:**
    * **Água:** Regeneração contínua.
    * **Energia:** Necessária para robôs. Não pode exceder capacidade máxima.

### UC-04 — Vender Produção
**Descrição:** Converte produção acumulada em dinheiro.
* **Fluxo Principal:**
    1. Jogador aciona “Vender”.
    2. Sistema calcula valor total.
    3. Remove produção do estoque.
    4. Adiciona dinheiro ao jogador.
* **Regras:**
    * Valor depende da cultura (milho, soja, etc.).

### UC-05 — Comprar Upgrade
**Descrição:** Permite melhorar eficiência da fazenda.
* **Fluxo Principal:**
    1. Jogador seleciona upgrade.
    2. Sistema verifica saldo.
    3. Deduz dinheiro.
    4. Aplica melhoria.
* **Tipos de Upgrade:** Produção, Eficiência, Automação, Capacidade.
* **Regra:** Custo cresce exponencialmente.

### UC-06 — Automatizar Produção
**Descrição:** Desbloqueia produção sem intervenção manual.
* **Fluxo Principal:**
    1. Jogador compra automação.
    2. Sistema altera estado da plantação.
    3. Produção passa a ocorrer automaticamente.
* **Regras:**
    * Requer energia.
    * Aplica multiplicador de eficiência.

### UC-07 — Evoluir Plantação
**Descrição:** Aumenta nível de uma cultura específica.
* **Fluxo:**
    1. Jogador investe dinheiro.
    2. Sistema aumenta nível (L).
    3. Produção é recalculada.
* **Regra:** Crescimento linear via nível.

### UC-08 — Monitorar Status da Fazenda
**Descrição:** Exibe informações em tempo real.
* **Dados exibidos:** Dinheiro, Produção total, Água, Energia.
* **Origem:** Atualizado via *Game Tick*.

### UC-09 — Expandir Capacidade
**Descrição:** Aumenta limites de recursos.
* **Fluxo:**
    1. Jogador compra upgrade.
    2. Sistema aumenta: Capacidade de água e Capacidade de energia.

### UC-10 — Loop de Jogo (Sistema)
**Descrição:** Processo automático contínuo do sistema.
* **Fluxo interno:**
    1. Calcular produção.
    2. Aplicar consumo.
    3. Aplicar regeneração.
    4. Atualizar estado global.
    5. Atualizar UI.
* **Frequência:** A cada 100ms.

---

## 🔗 Relacionamentos Entre Casos
* **UC-02** depende de **UC-06** (automação).
* **UC-01** e **UC-02** consomem **UC-03** (recursos).
* **UC-05** habilita **UC-06**, **UC-07**, **UC-09**.
* **UC-10** orquestra todos os processos automáticos.

---

## 🧠 Observações Arquiteturais (DDD)
* Cada UC deve mapear para um **Application Service**.
* **Entidades principais envolvidas:**
    * Plantação
    * Recurso (Água/Energia)
    * Upgrade
    * Robô
* **Eventos recomendados:**
    * `ProductionGenerated`
    * `ResourcesConsumed`
    * `UpgradePurchased`
    * `AutomationEnabled`