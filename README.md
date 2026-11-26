# DesafiosJava ☕

Repositório com os desafios e exercícios práticos que resolvi ao estudar Java com o curso **Maratona Java (DevDojo)**. Meu objetivo é me tornar desenvolvedor Java back-end.

Aqui ficam apenas exercícios concluídos e revisados. Os desafios principais têm um README próprio, que explica o problema, os conceitos usados e as decisões que tomei no código.

## 🧠 O que já estudei

- **Orientação a Objetos:** classes abstratas, herança, interfaces, enums, encapsulamento e polimorfismo
- **Exceções:** exceções checadas personalizadas, `throw` e `throws`, vários `catch`, propagação e `try-with-resources`
- **Arquivos:** leitura e escrita com `java.io`, `java.nio` (`Path`, `Files`, `DirectoryStream`) e serialização
- **Coleções:** `List`, `Set`, `Map`, `Queue`, `Deque`, `PriorityQueue`, `TreeSet`, `TreeMap`, `Iterator`, `Comparable`, `Comparator`, `equals` e `hashCode`
- **Generics:** classes e métodos genéricos e wildcards
- **Classes internas:** classes internas, aninhadas estáticas, anônimas e locais
- **Programação funcional:** parametrização de comportamento, lambdas, interfaces funcionais (`Predicate`, `Function`, `Consumer`), method reference e `Optional`

## ✅ Desafios principais

| Desafio | O que resolve | Conceitos aplicados |
|---|---|---|
| [02 — Folha de Pagamento](src/folhapagamento) | Calcula salário e bônus de funcionários CLT e comissionados | Classe abstrata, herança, interface, enum, polimorfismo, `toString()` em cadeia |
| [03 — Validação de Saque](src/validarsaque) | Valida saques e registra cada tentativa em arquivo de log | Exceções checadas personalizadas, `try-with-resources`, separação de responsabilidades |
| [04 — Inscrições em Cursos](src/colecoes) | Remove inscrições duplicadas, ordena alunos e conta por faixa etária | `List`, `LinkedHashSet`, `equals`/`hashCode`, `Comparator`, `Map` |
| [Trilha de Coleções e Generics](src/generics) | Seis exercícios de fixação | `Comparable`, `TreeSet`/`TreeMap`, `Iterator`, `getOrDefault`, filas, Generics com wildcards |
| 05 — Biblioteca Digital | Em andamento | Repositório genérico com filtros usando `Predicate` e `Optional` |

## 🧩 Exercícios de fixação

| Tema | Pasta |
|---|---|
| Classes abstratas e herança (formas geométricas) | `refrescar` |
| Interface, enum e classe abstrata (sistema de entregas) | `entregas` |
| Interfaces e polimorfismo (tipos de profissional) | `pagavelfree` |
| Interface e enum com atributos (lanchonete) | `fixacaoenum` |
| Exceções personalizadas | `excecoes`, `multiplasexception`, `propagacao` |
| `Map` e exceções (controle de estoque) | `controledeestoque` |
| Leitura e escrita de arquivos | `leituraescrita`, `nio`, `serializable` |
| Classes internas (carrinho de compras) | `classesinternas` |
| Parametrização de comportamento (concessionária) | `parametrizacao` |
| Lambdas com `Predicate`, `Function` e `Consumer` | `lambdas` |

## 📌 Próximos passos

- [ ] Streams
- [ ] Threads e concorrência
- [ ] SQL com JDBC
- [ ] Testes automatizados com JUnit
- [ ] Spring Boot

## 🛠️ Tecnologias

- Java 17+
- IntelliJ IDEA
- Sem frameworks por enquanto: o foco atual são os fundamentos da linguagem

## ▶️ Como executar

1. Clone o repositório e abra a pasta no IntelliJ IDEA.
2. Cada exercício tem uma classe com o método `main`, geralmente na pasta `test` ou `app`.
3. Clique com o botão direito nessa classe e escolha **Run**.

## 👤 Autor

**Gustavo de Camargo Monteiro**
[LinkedIn](https://www.linkedin.com/in/gustavo-camargo-5498a2246/)