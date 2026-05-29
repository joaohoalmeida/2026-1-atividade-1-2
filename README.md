# Servidor Echo em Java — Versões Sequencial e Concorrente

Projeto da disciplina de Sistemas Operacionais

#Implementação de um servidor echo em Java utilizando TCP, com duas versões: sequencial (sem threads) e concorrente (com threads).

## Integrantes

- João
- Ryan
- Matheus

## Sobre o Projeto

O servidor escuta na porta `6789` e aceita conexões de clientes TCP. Cada cliente envia 10 mensagens com delay de 200ms e a conexão é encerrada quando o cliente fecha o socket. O projeto possui duas versões do servidor para comparação:

- **Sequencial**: atende um cliente por vez, sem threads
- **Concorrente**: com thread, onde cada cliente é atendido em sua própria thread

### Funcionalidades

- **Servidor sequencial**: atende um cliente por vez, lógica inline no loop de `accept()`
- **Servidor concorrente**: Thread instanciado a cada conexão, cada cliente é atendido em sua própria thread
- **Cliente reutilizável**: mesma classe `Client` para ambas as versões, recebe nome via `args[0]`
- **Múltiplos clientes**: `echo-client` e `echo-client-2` rodam simultaneamente usando a mesma classe com nomes diferentes via argumentos
- **Comunicação contínua**: o servidor lê mensagens em loop até o cliente desconectar
- **Demonstração de concorrência**: na versão com threads, ambos os clientes enviam mensagens com delay, gerando interleaving visível nos logs do servidor

### Estrutura

```
docker-compose-echo-java-thread/
├── server/                          # Servidor sequencial (sem threads)
│   ├── Server.java
│   └── Dockerfile
├── server-thread/                   # Servidor concorrente (com threads)
│   ├── Server.java
│   ├── ServerThread.java
│   └── Dockerfile
├── client/                          # Cliente compartilhado
│   ├── Client.java                  # Recebe nome via args, envia 10 mensagens com delay
│   └── Dockerfile
├── docker-compose-single.yml        # Orquestra versão sequencial
└── docker-compose-thread.yml        # Orquestra versão concorrente
```

### Como executar

#### Versão concorrente (com threads)

```bash
cd docker-compose-echo-java-thread
docker compose -f docker-compose-thread.yml up --build
```

#### Versão sequencial (sem threads)

```bash
cd docker-compose-echo-java-thread
docker compose -f docker-compose-single.yml up --build
```

O nome de cada cliente é passado como argumento de linha de comando no `docker-compose`:

```yaml
echo-client:
  command: ["java", "Client", "Client 1"]

echo-client-2:
  command: ["java", "Client", "Client 2"]
```

A classe `Client` recebe o nome via `args[0]` no `main` e o utiliza para identificar as mensagens enviadas ao servidor.

### Output esperado — Versão concorrente

```
echo-server    | Porta 6789 aberta
echo-client    | Conectado ao servidor!
echo-server    | Client 1 no endereco /172.18.0.3 conectou!
echo-client    | O servidor enviou: Bem-vindo ao servidor!
echo-client-2  | Conectado ao servidor!
echo-server    | Client 2 no endereco /172.18.0.4 conectou!
echo-client-2  | O servidor enviou: Bem-vindo ao servidor!
echo-server    | Cliente 1 enviou: Client 1 - Testando: 0
echo-server    | Cliente 2 enviou: Client 2 - Testando: 0
echo-server    | Cliente 1 enviou: Client 1 - Testando: 1
echo-server    | Cliente 2 enviou: Client 2 - Testando: 1
...
```

### Output esperado — Versão sequencial

```
echo-server    | Porta 6789 aberta
echo-client    | Conectado ao servidor!
echo-client    | O servidor enviou: Bem-vindo ao servidor!
echo-server    | Cliente enviou Cliente 1 - Testando: 0
echo-server    | Cliente enviou Cliente 1 - Testando: 1
...
echo-server    | Cliente enviou Cliente 1 - Testando: 9
echo-client    | Comunicacão fechada
echo-client-2  | Conectado ao servidor!
echo-client-2  | O servidor enviou: Bem-vindo ao servidor!
echo-server    | Cliente enviou Cliente 2 - Testando: 0
echo-server    | Cliente enviou Cliente 2 - Testando: 1
...
```

### Comparação

| | Sequencial | Concorrente |
|---|---|---|
| **Atendimento** | Um cliente por vez | Múltiplos clientes simultaneamente |
| **Threads** | Nenhuma | Uma por cliente |
| **Tempo total** | ~4s (2s por cliente) | ~2s (paralelo) |
| **Cliente 2** | Aguarda Cliente 1 desconectar | Conecta e envia em paralelo |