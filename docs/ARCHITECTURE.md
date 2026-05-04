# 🧱 RoboFarm Idle — Architecture

## 🎯 Objetivo

Definir uma arquitetura simples, testável e evolutiva para um *idle game* em Java, mantendo:

* **Separação de responsabilidades (SRP)**
* **Baixo acoplamento (DIP)**
* **Evolução para múltiplas UIs (Swing → JavaFX → LibGDX)**
* **Velocidade de entrega (MVP em 1 dia)**

---

## 🧭 Visão Geral

```text
UI (Swing)
   ↓
Application (Use Cases)
   ↓
Domain (Regras de Negócio)
```

* **UI**: captura input e renderiza estado
* **Application**: orquestra ações do jogador
* **Domain**: contém regras e estado do jogo

---

## 📦 Estrutura de Diretórios

```text
robofarm/
├── core/
│   └── src/main/java/com/robofarm/
│       ├── domain/
│       │   └── model/entity/
│       ├── application/
│       │   └── usecase/
│       └── shared/ (futuro)
│
└── interfaces/
    ├── swing/
    │   └── src/main/java/com/robofarm/swing/
    │       ├── Main.java
    │       ├── game/
    │       └── ui/
    ├── javafx/ (futuro)
    └── libgdx/ (futuro)
```

---

## 🧠 Domain Layer

### 📌 Responsabilidade

* Regras de negócio
* Estado do jogo
* Invariantes

### 📦 Entidades principais

#### `Farm`

* Agregado raiz
* Controla:

    * dinheiro
    * produção
    * recursos (água)

#### `Plantation`

* Produção base
* Nível

#### `WaterResource`

* Consumo
* Regeneração

---

### ⚙️ Regras principais

* Produção depende de água
* Venda converte produção → dinheiro
* Recursos nunca negativos

---

### ✅ Exemplo (comportamento rico)

```java
public void produce() {
    if (!waterResource.consume(1)) return;

    double amount = plantation.produce();
    production += amount;
}
```

---

## ⚙️ Application Layer

### 📌 Responsabilidade

* Orquestrar casos de uso
* Não contém regra de negócio

### 📦 Use Cases

* `ProduceUseCase`
* `SellUseCase`
* `GameTickUseCase`
* `UpgradePlantationUseCase`

---

### 🔁 Exemplo

```java
public class SellUseCase {

    private static final double PRICE = 2.0;

    public void execute(Farm farm) {
        farm.sell(PRICE);
    }
}
```

---

## 🖥️ Interface Layer (Swing)

### 📌 Responsabilidade

* Input do usuário
* Renderização
* Game Loop

---

### Componentes

#### `Main`

* Bootstrap do sistema
* Conecta Domain + Application + UI

#### `GameLoop`

* Executa a cada 100ms
* Chama `GameTickUseCase`
* Atualiza UI

#### `FarmPanel`

* Exibe estado do jogo
* Botões de interação

---

## 🔄 Game Loop

Executado via `javax.swing.Timer`:

```text
Tick (100ms):
1. Produção
2. Consumo de recursos
3. Regeneração
4. Atualização da UI
```

---

## 🔗 Fluxo de Execução

### Produzir

```text
UI (botão)
   ↓
ProduceUseCase
   ↓
Farm.produce()
```

---

### Tick automático

```text
GameLoop
   ↓
GameTickUseCase
   ↓
Farm.produce()
   ↓
WaterResource.tick()
```

---

## 📐 Princípios Arquiteturais

### 1. Dependency Rule

```text
UI → Application → Domain
```

* Dependências sempre apontam **para dentro**

---

### 2. Encapsulamento

Evitar:

```java
farm.production = 100; // ❌
```

Preferir:

```java
farm.produce(); // ✔
```

---

### 3. Tell, Don’t Ask

Evitar:

```java
if (farm.getWater() > 0) { ... }
```

Preferir:

```java
farm.produce();
```

---

### 4. UI não contém regra de negócio

```java
button.addActionListener(e -> useCase.execute(farm));
```

---

## ⚠️ Decisões (MVP)

### Simplificações adotadas

* Domain e Application no mesmo módulo (`core`)
* Sem eventos de domínio
* Sem persistência
* Sem múltiplas culturas
* Sem energia (por enquanto)

---

## 🚀 Evolução futura

### Curto prazo

* [ ] Upgrade exponencial
* [ ] Botão vender
* [ ] Automação básica

---

### Médio prazo

* [ ] Energia
* [ ] Múltiplas culturas
* [ ] Domain Events

---

### Longo prazo

* [ ] Separar módulos Maven
* [ ] Migrar UI para LibGDX
* [ ] Persistência (save/load)

---

## 📌 Regras de Ouro

* Domain não conhece UI
* UI não contém regra de negócio
* UseCase orquestra, não decide regras
* Entidades controlam seu próprio estado

---

## 🏁 Conclusão

A arquitetura prioriza:

* **Entrega rápida**
* **Baixa complexidade**
* **Evolução segura**

Sem comprometer princípios fundamentais de engenharia de software.
