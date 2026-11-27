# Desafio 5 — Biblioteca Digital

Desafio de consolidação do curso Maratona Java (DevDojo), feito antes do bloco de **Streams**. Junta num único sistema os conteúdos de Coleções, Generics, Classes Internas, Lambdas, Method Reference e Optional.

## O problema

Uma biblioteca precisa cadastrar livros sem duplicados, consultar o acervo, emprestar livros, fazer buscas que podem não encontrar nada, contar livros por gênero e remover os mais antigos.

## Conceitos praticados

| Conceito | Onde foi usado |
|---|---|
| `enum` com atributo e construtor | `Genero`, com a descrição de cada gênero |
| `Comparable` | ordem natural do `Livro` por título |
| `equals()` e `hashCode()` | dois livros são iguais quando têm o mesmo ISBN |
| `LinkedHashSet` | remoção do livro duplicado, mantendo a ordem de chegada |
| Classe genérica `Repositorio<T>` | guarda itens de qualquer tipo |
| Método genérico `<R>` | `transformar` devolve uma lista de outro tipo |
| `Collections.unmodifiableList` | `listarTodos()` devolve uma lista só de leitura |
| `Predicate` | `filtrar`, `buscarPrimeiro` e `removerSe` |
| `Function` | `transformar` |
| `Consumer` / `forEach` | empréstimo e impressão |
| Method reference | `Livro::isDisponivel`, `Livro::getTitulo`, `repositorioLivros::adicionar`, `System.out::println` |
| `Optional` | buscas que podem não ter resultado, sem `get()` puro |
| `TreeMap` + `getOrDefault` | contagem por gênero em ordem alfabética |
| `removeIf` | remoção segura durante a repetição |

## Estrutura do projeto

```
bibliotecadigital
├── domain
│   ├── Genero.java
│   ├── Livro.java
│   └── Repositorio.java
└── teste
    └── LivroTeste.java
```

### `Repositorio<T>`

| Método | Recebe | Devolve |
|---|---|---|
| `adicionar(T item)` | um item | — |
| `listarTodos()` | — | lista **só de leitura** |
| `filtrar(Predicate<T>)` | uma regra | os itens que passam |
| `<R> transformar(Function<T, R>)` | uma transformação | lista de outro tipo |
| `buscarPrimeiro(Predicate<T>)` | uma regra | `Optional<T>`: o primeiro que passa, ou vazio |
| `removerSe(Predicate<T>)` | uma regra | — |

## Etapas

### Etapa 1 — Cadastro sem duplicados
Nove livros entram numa `List`, um deles com ISBN repetido. A lista passa por um `LinkedHashSet` e cada livro único vai para o repositório:

```java
Set<Livro> livrosUnicos = new LinkedHashSet<>(livros);
livrosUnicos.forEach(repositorioLivros::adicionar);
```

Resultado: **8 livros**. O segundo *Effective Java* é recusado pelo `equals`/`hashCode`.

### Etapa 2 — Consultas (Predicate)
- **Disponíveis:** `filtrar(Livro::isDisponivel)` → 6 livros.
- **Tecnologia a partir de 2015:** Effective Java e Refactoring. O Refactoring aparece mesmo emprestado, porque a regra não pergunta pela disponibilidade. O gênero é comparado com `==`, por ser enum.

### Etapa 3 — Transformações (Function)
- Títulos em ordem alfabética: o `transformar` devolve uma `List<String>`, ordenada com `Collections.sort`, que usa a ordem natural da String. **1984** vem primeiro, porque números vêm antes das letras.
- Fichas no formato `Clean Code - Robert Martin (2008)`, montadas com `String.format` dentro de uma lambda.

### Etapa 4 — Empréstimo (Consumer)
Os livros de Machado de Assis são filtrados e emprestados com `setDisponivel(false)`. Ao listar o repositório, eles aparecem como emprestados: **a lista filtrada é nova, mas os livros dentro dela são os mesmos objetos**.

### Etapa 5 — Buscas (Optional)

| Busca | Resultado |
|---|---|
| ISBN `004` | Effective Java |
| ISBN `999` | não encontrado |
| Mais antigo disponível | O Cortiço |

As buscas usam `map` para trocar o livro pelo título e `orElse` para abrir a caixa com segurança. Para o mais antigo disponível, os disponíveis são filtrados **de novo**: a lista da Etapa 2 foi criada antes do empréstimo e ainda continha livros emprestados.

### Etapa 6 — Contagem por gênero (Map)

```java
contagemGeneros.put(descricao, contagemGeneros.getOrDefault(descricao, 0) + 1);
```

| Gênero | Quantidade |
|---|---|
| Ficção | 4 |
| História | 1 |
| Tecnologia | 3 |

A chave é a **descrição** (String). Com o enum como chave, o `TreeMap` ordenaria pela ordem de declaração, e não pela alfabética.

### Etapa 7 — Limpeza (removeIf)
`removerSe(l -> l.getAno() < 1950)` remove Dom Casmurro, 1984, O Cortiço e Memórias Póstumas, inclusive os emprestados. Ficam Clean Code, Sapiens, Effective Java e Refactoring.

## O que aprendi

- **Lista nova não é objeto novo.** Alterar um livro por uma lista filtrada altera o mesmo livro em todas as coleções.
- **Uma lista filtrada não se refiltra sozinha.** Se o estado dos objetos muda, é preciso filtrar de novo.
- **Remover de uma coleção não remove das outras.** Depois da Etapa 7, o Set `livrosUnicos` continua com 8 livros.
- **Optional serve para resultados que podem não existir**, e não simplesmente para métodos que devolvem um valor só.
- **`return` dentro do `for` encerra a busca** assim que o primeiro item é encontrado.
- **Lista só de leitura recusa alterações com exceção** (`UnsupportedOperationException`), enquanto o Set recusa duplicados em silêncio.
- **String se compara com `equals`; enum, com `==`.** Comparar um enum com um texto dá sempre `false`, sem erro.
- **Method reference só quando a lambda faz uma única chamada**, repassando o parâmetro. Com condições, contas ou textos fixos, fica como lambda.
- **Testar valores de fronteira** (2015, 1950) evita erros silenciosos de `>` e `>=`.

## Como executar

Abra o projeto no IntelliJ IDEA e execute a classe `bibliotecadigital.teste.LivroTeste`.