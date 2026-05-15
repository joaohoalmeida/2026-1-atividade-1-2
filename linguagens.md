# Linguagens de programação do trabalho sobre multiplas linhas de execução

**by google gemini**

A tabela abaixo apresenta a classificação detalhada das 18 linguagens para o seu trabalho, cobrindo o paradigma principal, o objetivo de mercado, o modelo exato de concorrência/thread e o link para a documentação ou site oficial de cada uma:

| Linguagem | Paradigma Principal | Objetivo / Caso de Uso Principal | Modelo de Thread / Concorrência | Link Oficial |
|---|---|---|---|---|
| Ada | Imperativo / Concorrente | Sistemas embarcados de segurança crítica | Tasks nativas (Threads de hardware mapeadas na sintaxe) e Objetos Protegidos | Ada-Lang[](https://ada-lang.io/) |
| C# | Multiparadigma / OO | Sistemas corporativos e jogos (Unity) | Threads gerenciadas (Thread), Pool de Threads e async/await | Microsoft .NET |
| C++ | Multiparadigma / Sistemas | Software de alto desempenho e jogos AAA | Threads de sistema operacional nativas (std::thread, std::jthread) | Cppreference |
| Clojure | Funcional | Processamento de dados na JVM | Software Transactional Memory (STM), Agents e Atoms | Clojure |
| Elixir | Funcional / Atores | Sistemas web distribuídos de alta escala | Processos ultra-leves na BEAM VM (Modelo de Atores com isolamento total) | Elixir |
| Erlang | Funcional / Atores | Telecomunicações e sistemas tolerantes a falhas | Processos ultra-leves na BEAM VM (Passagem de mensagens assíncronas) | Erlang |
| Go (Golang) | Imperativo / Concorrente | Microsserviços e infraestrutura de nuvem | Goroutines (Múltiplas Green Threads mapeadas em threads de S.O. via canais) | Go Dev |
| Haskell | Funcional Puro | Pesquisa acadêmica e sistemas financeiros | Software Transactional Memory (STM) e Green Threads leves gerenciadas pelo GHC | Haskell |
| Java | Orientado a Objetos | Aplicações corporativas e bancárias | Threads de S.O. tradicionais e Virtual Threads (Projeto Loom, Green Threads modernas) | Java Oracle |
| Kotlin | Multiparadigma / OO | Desenvolvimento Android e Backend | Corrotinas (Concorrência estruturada suspensiva sem bloquear threads de S.O.) | Kotlin |
| Lua | Multiparadigma / Script | Linguagem de extensão embutida em jogos/C | Corrotinas cooperativas (Concorrência assimétrica dentro de uma única thread) | Lua[](https://www.fsf.org/) |
| OCaml | Funcional Multiparadigma | Ferramentas estáticas e finanças quantitativas | Multicore OCaml (Threads em paralelo reais e Efeitos Algébricos desde a v5.0) | OCaml |
| PHP | Multiparadigma / Web | Criação de sites e APIs web dinâmicas | Nativamente single-threaded, mas suporta Threads Reais isoladas (Extensão parallel) | PHP |
| Rust | Imperativo / Sistemas | Infraestrutura de rede e segurança de memória | Threads nativas com garantia de ausência de data races em compilação (Fearless Concurrency) | Rust |
| Scala | Híbrido Puro (OO + Funcional) | Processamento de Big Data (Apache Spark) | Modelo de Atores (via ecossistemas como Akka/Pekko) construído sobre a JVM | Scala |
| Smalltalk | Orientado a Objetos Puro | Educacional, prototipagem e interfaces | Green Threads cooperativas gerenciadas inteiramente pela Máquina Virtual | Squeak Smalltalk[](https://squeak.org/) |
| TypeScript | Multiparadigma / Estático | Aplicações web complexas front/backend | Execução Single-threaded baseada em Loop de Eventos; concorrência via Worker Threads | TypeScript |
| Zig | Imperativo / Sistemas | Programação de baixo nível (sucessor do C) | Threads nativas do S.O. gerenciadas manualmente sem runtime oculto | Zig |

## Como expandir a sua análise na pesquisa:

Se você precisar detalhar a comparação, posso estruturar tópicos focados na segurança de memória (ex: o Ownership do Rust vs a imutabilidade do Clojure) ou no custo computacional de criar uma nova thread (ex: Goroutines vs Threads de S.O. em C++). Qual desses aspectos você gostaria de aprofundar primeiro?

