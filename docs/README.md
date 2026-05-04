# 🌱 RoboFarm Idle

## 🎯 Visão
Jogo incremental focado em automação agrícola.

> Produzir → Vender → Investir → Automatizar

---

## 🎮 Gameplay

### Ações principais
- Produzir
- Vender
- Upgrade

### Recursos
- 💰 Dinheiro
- 🌾 Produção
- 💧 Água

---

## ⚙️ Mecânicas (simplificadas)

### Produção
P = base * nível

### Venda
dinheiro = produção * preço

---

## 🖥️ Como rodar

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.robofarm.swing.Main"