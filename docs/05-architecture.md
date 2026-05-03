# 📄 05 — Architecture (RoboFarm Idle)

## 🎯 Objetivo
Definir a arquitetura do sistema com foco em:
* **Separação de responsabilidades (SRP)**: Isolar lógica de jogo de interface gráfica.
  * **Baixo acoplamento (DIP)**: Depender de abstrações, não de implementações.
  * **Alta testabilidade**: Permitir testes de lógica sem necessidade de abrir a UI.
  * **Evolução futura**: Facilitar a migração para **LibGDX** e novos sistemas de persistência.

---

## 🧱 Estilo Arquitetural

### 📌 Abordagem Principal
* **Arquitetura Hexagonal (Ports & Adapters)**
  * **Domain-Driven Design (DDD)**
  * **Event-Driven Architecture** (Comunicação via eventos)
  * **Game Loop baseado em Tick (100ms)**

### 🧭 Visão de Alto Nível

```text
                ┌──────────────────────────┐
                │        UI (Swing)        │
                │   (Adapter - Driving)    │
                └──────────┬───────────────┘
                           │
                           ▼
                ┌──────────────────────────┐
                │    Application Layer     │
                │  (Use Cases / Services)  │
                └──────────┬───────────────┘
                           │
                           ▼
                ┌──────────────────────────┐
                │       Domain Layer       │
                │ (Entities + Rules + EV)  │
                └──────────┬───────────────┘
                           │
          ┌────────────────┴────────────────┐
          ▼                                 ▼
   ┌──────────────┐                  ┌──────────────┐
   │ Persistence  │                  │ Game Engine  │
   │ (Future)     │                  │ (Game Loop)  │
   │ Adapter      │                  │ Adapter      │
   └──────────────┘                  └──────────────┘