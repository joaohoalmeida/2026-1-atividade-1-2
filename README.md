# Servidor Echo Concorrente em Java

Projeto da disciplina de Sistemas Operacionais — implementação de um servidor echo concorrente utilizando TCP e threads em Java.

## Integrantes

- João
- Ryan
- Matheus

## Sobre o Projeto

O servidor escuta na porta `6789` e, para cada cliente que conecta, cria uma nova thread para atendê-lo. Cada cliente pode enviar múltiplas mensagens e a conexão só é encerrada quando o cliente fecha o socket.

### Funcionalidades

- **Servidor concorrente**: Thread-per-Connection — cada cliente é atendido em sua própria thread
- **Múltiplos clientes**: `echo-client` e `echo-client-2` rodam simultaneamente
- **Comunicação contínua**: O servidor lê mensagens em loop até o cliente desconectar
- **Demonstração de concorrência**: Ambos os clientes enviam mensagens com delay, gerando interleaving visível nos logs do servidor

### Estrutura

```
docker-compose-echo-java/
├── server/
│   ├── Server.java         # Servidor TCP com thread por cliente
│   ├── ServerThread.java   # Lógica de atendimento do cliente (loop de leitura)
│   └── Dockerfile
├── client/
│   ├── Client.java         # Cliente 1 — envia 10 mensagens com delay
│   ├── Cliente_2.java      # Cliente 2 — envia 10 mensagens com delay
│   └── Dockerfile
└── docker-compose.yml      # Orquestra 3 serviços: server, client, client-2
```

### Como executar

```bash
cd docker-compose-echo-java
docker compose up --build
```

### Output esperado

```
echo-server  | Porta 6789 aberta
echo-client-2  | Cliente 2 conectado ao servidor!
echo-server    | Client 1 no endereco /172.18.0.3 conectou!
echo-client-2  | O servidor enviou para o Cliente 2: Bem-vindo ao servidor!
echo-server    | Cliente 1 enviou: Cliente 2 - Testando: 0
echo-client    | Conectado ao servidor!
echo-server    | Client 2 no endereco /172.18.0.4 conectou!
echo-server    | Cliente 2 enviou: Cliente 1 - Testando: 0
echo-server    | Cliente 1 enviou: Cliente 2 - Testando: 1
echo-server    | Cliente 2 enviou: Cliente 1 - Testando: 1
...
```

## Material de Estudo

| Arquivo | Conteúdo |
|---------|----------|
| [ESTUDO_INDEX.md](ESTUDO_INDEX.md) | Índice com links para todos os materiais |
| [ESTUDO.md](ESTUDO.md) | Visão geral do projeto |
| [ESTUDO_SERVER.md](ESTUDO_SERVER.md) | Detalhamento do `Server.java` |
| [ESTUDO_SERVERTHREAD.md](ESTUDO_SERVERTHREAD.md) | Detalhamento do `ServerThread.java` |
| [ESTUDO_CLIENT.md](ESTUDO_CLIENT.md) | Detalhamento dos clientes |
| [ESTUDO_DOCKER.md](ESTUDO_DOCKER.md) | Detalhamento do Docker & Docker Compose |
