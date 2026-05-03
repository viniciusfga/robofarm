classDiagram

%% =======================
%% DOMAIN LAYER
%% =======================

class Jogador {
-double dinheiro
-double producaoTotal
-Recurso agua
-Recurso energia
+venderProducao()
+comprarUpgrade(upgrade)
}

class Plantacao {
-String tipo
-int nivel
-double producaoBase
-double multiplicador
-boolean automatizada
+calcularProducao()
+evoluir()
}

class Recurso {
-double quantidade
-double capacidadeMaxima
-double taxaRegeneracao
+consumir(valor)
+regenerar()
}

class Upgrade {
-String tipo
-int nivel
-double custoBase
-double taxaCrescimento
+calcularCusto()
+aplicar()
}

class Robo {
-String tipo
-double eficiencia
-boolean ativo
+automatizar(plantacao)
}

%% =======================
%% APPLICATION LAYER
%% =======================

class FarmService {
+produzirManual()
+produzirAutomatico()
+gerenciarRecursos()
+vender()
+comprarUpgrade()
}

class GameLoop {
+tick()
}

%% =======================
%% RELATIONSHIPS
%% =======================

Jogador "1" --> "1..*" Plantacao
Jogador "1" --> "1" Recurso : agua
Jogador "1" --> "1" Recurso : energia
Jogador "1" --> "0..*" Upgrade

Plantacao --> Robo
Plantacao --> Recurso : consome

Upgrade --> Plantacao : afeta
Upgrade --> Robo : melhora

Robo --> Recurso : consome energia

FarmService --> Jogador
FarmService --> Plantacao
FarmService --> Upgrade
FarmService --> Robo

GameLoop --> FarmService