# DesafiosJava 🍵

Repositório de estudos e exercícios práticos em Java, desenvolvido durante minha jornada para me tornar uma desenvolvedora Java pronta para o mercado (freelance e bigtech).

Aqui ficam apenas os desafios já validados e organizados — sem código de rascunho ou tentativas intermediárias.

# 🎯 Objetivo

Consolidar, na prática, os conceitos de Java estudados através do curso Maratona Java, evoluindo de fundamentos de Orientação a Objetos até tópicos avançados como Streams, Concorrência e persistência com JDBC.

# 🧠 Tópicos já estudados
Orientação a Objetos: classes abstratas, herança, interfaces, enums, encapsulamento, polimorfismo
toString() e polimorfismo: sobrescrita em cadeia (super.toString()) para reaproveitar lógica entre classe pai e filha
Tratamento de Exceções: exceções checked customizadas (extends Exception), throw/throws, captura em múltiplos catch
I/O e Persistência: NIO, Serialização, try-with-resources, escrita de log em arquivo (BufferedWriter/FileWriter)
Estruturas de dados: Map e organização de coleções
# 📌 Próximos tópicos (roadmap)
Coleções (List, Set, Queue)
Generics
Streams
Threads / Concorrência
JDBC (conexão com banco de dados)
JUnit (testes automatizados)
Spring Framework

# 📂 Estrutura do repositório
DesafiosJava/
├── desafio-02-folha-pagamento/
│   ├── README.md
│   ├── Funcionario.java
│   ├── FuncionarioCLT.java
│   ├── FuncionarioComissado.java
│   ├── Bonificavel.java
│   ├── Cargo.java
│   └── FuncionarioTest.java
├── desafio-03-validacao-saque/
│   ├── README.md
│   ├── ContaBancaria.java
│   ├── ValorInvalidoException.java
│   ├── SaldoInsuficienteException.java
│   └── SaqueTest.java
└── README.md

Cada pasta de desafio tem seu próprio README.md, explicando o problema resolvido e os conceitos aplicados.

# ✅ Desafios concluídos
Desafio	Descrição	Conceitos aplicados	Status
02 — Folha de Pagamento	Cálculo de salário e bônus para diferentes tipos de funcionário	Classe abstrata, herança, interface, enum, polimorfismo, toString()	✅ Concluído
03 — Validação de Saque	Validação de saque bancário com log de tentativas em arquivo	Exceções checked customizadas, try-with-resources, separação de responsabilidades	✅ Concluído
# 🛠️ Tecnologias
Java (JDK 17+)
Sem frameworks externos por enquanto — foco em fundamentos da linguagem
# 🚀 Como rodar
bash
javac NomeDaClasse.java
java NomeDaClasse
👩# ‍💻 Autor

Desenvolvido por Kalango, como parte da preparação para o mercado de trabalho Java (freelance e bigtech).