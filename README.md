# Servidor Echo Concorrente em Java

Projeto da disciplina de Sistemas Operacionais — implementação de um servidor echo concorrente utilizando TCP e threads em Java.

## Integrantes

- João
- Ryan
- Matheus

## Sobre o Projeto

O servidor escuta na porta `6789` e, para cada cliente que conecta, cria uma nova thread para atendê-lo. O cliente envia uma mensagem e a conexão é encerrada.

### Estrutura

```
docker-compose-echo-java/
├── server/
│   ├── Server.java         # Servidor TCP com thread por cliente
│   ├── ServerThread.java   # Lógica de atendimento do cliente
│   └── Dockerfile
├── client/
│   ├── Client.java         # Cliente TCP
│   └── Dockerfile
└── docker-compose.yml
```

### Como executar

```bash
cd docker-compose-echo-java
docker compose up --build
```
