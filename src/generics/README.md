# Trilha de Fixação — Coleções e Generics

Sequência de seis exercícios curtos para reforçar os pontos de **Coleções** e **Generics** do curso Maratona Java (DevDojo) que ficaram menos praticados. Cada exercício foi feito em etapas, sempre escrevendo a previsão do resultado antes de rodar.

## Exercícios

| # | Tema | Pacote |
|---|---|---|
| 1 | Comparable | `generics` |
| 2 | TreeSet e TreeMap | `generics` |
| 3 | Iterator, `removeIf` e `ConcurrentModificationException` | `iterator` |
| 4 | `getOrDefault` | `iterator` |
| 5 | Queue, PriorityQueue e Deque (pilha) | `queue` |
| 6 | Generics: classe genérica, método com `<T>`, restrição e wildcards | `generics` |

---

## 1. Biblioteca — Comparable

A classe `Livros` implementa `Comparable<Livros>` e define a **ordem natural por título**. Com isso, `Collections.sort(lista)` ordena sem precisar de Comparator.

**Aprendizados**
- O `compareTo` de String compara caractere por caractere: **números vêm antes das letras** e **maiúsculas antes das minúsculas**.
- Sem `implements Comparable`, o `Collections.sort(lista)` gera **erro de compilação**, porque o método exige `T extends Comparable`.

## 2. Biblioteca ordenada — TreeSet e TreeMap

- **TreeSet:** os livros ficam sempre ordenados por título. Um livro com o mesmo título de outro, mas com autor e ano diferentes, é **recusado**.
- **TreeMap:** chave = ano, valor = título. As chaves aparecem em ordem crescente.
- Navegação: `first()`, `last()`, `firstKey()`, `lastKey()` e `headMap(2003)`, que retorna apenas 2001 e 2002.

**Aprendizados**
- **HashSet decide duplicados pelo `equals`/`hashCode`. TreeSet decide pelo `compareTo`.** Se o `compareTo` retorna zero, o TreeSet considera os objetos iguais.
- **Map substitui, Set recusa.** No Map, o último `put` na mesma chave vence, e o `size()` não muda.

## 3. Lista de Tarefas — Iterator e removeIf

- **Parte A:** um `Iterator` remove as tarefas concluídas com `it.remove()` e conta quantas foram removidas.
- **Parte B:** `removeIf(t -> t.getPrioridade() == 3)` remove as de prioridade 3 em uma linha.
- **Parte C:** remover dentro de um `for-each` com `lista.remove()` provoca `ConcurrentModificationException`, de propósito.

**Aprendizados**
- O `for-each` usa um Iterator escondido. Remover pela lista "pelas costas" dele gera a exceção na **volta seguinte**, quando o `next()` percebe a mudança.
- Criar o Iterator **antes** de terminar de montar a lista também gera a exceção.
- Durante a repetição, quem remove é o **Iterator** ou o **`removeIf`**.

## 4. Contagem por prioridade — getOrDefault

A contagem de tarefas por prioridade foi feita em uma linha, sem `if`:

```java
contagem.put(prioridade, contagem.getOrDefault(prioridade, 0) + 1);
```

**Aprendizados**
- O `getOrDefault` evita o `NullPointerException` de somar 1 a um `null`.
- Ele **só lê**: nunca adiciona nada ao Map. Quem grava é o `put`.
- Para a saída sair sempre em ordem de chave, usa-se `TreeMap`.

## 5. Pronto-socorro — Queue, PriorityQueue e Deque

- **Parte A:** `Queue` com `ArrayDeque` atende por **ordem de chegada** (FIFO).
- **Parte B:** `PriorityQueue` com um Comparator invertido atende **o mais grave primeiro**.
- **Parte C:** `Deque` como **pilha** simula um "desfazer" com `push` e `pop` (LIFO).

**Aprendizados**
- A PriorityQueue garante a ordem **só na cabeça da fila**. Imprimir a fila inteira não mostra a ordem de prioridade; apenas o `poll()` revela.
- Com a fila vazia: `poll()` retorna `null` (silencioso) e `remove()` lança `NoSuchElementException` (exceção).

## 6. Generics na prática

### Parte A — Classe genérica
`Repositorio<T>` guarda itens de qualquer tipo, com `adicionar`, `listarTodos` e `quantidade`. Foi usado com `Livros`, `Paciente`, `Cachorro`, `Gato` e `Animal`. Adicionar um `Paciente` num `Repositorio<Livros>` gera **erro de compilação**.

### Parte B — Método genérico com restrição e sobrecarga

```java
static <T extends Comparable<T>> T maior(List<T> lista)
static <T> T maior(List<T> lista, Comparator<T> comparador)
```

| Lista | Quem compara | Resultado |
|---|---|---|
| Livros | `Livros.compareTo` (título) | O Principe |
| `List.of(3, 17, 8, 12)` | `Integer.compareTo` | 17 |
| Pacientes | `PrioridadeComparator().reversed()` | Andre |

A primeira versão não aceita pacientes, porque `Paciente` não é `Comparable`. A segunda resolve sem alterar a classe, recebendo a regra pelo parâmetro.

### Parte C — Wildcards

```java
static void fazerBarulho(List<? extends Animal> lista)    // lê
static void adotarCachorros(List<? super Cachorro> lista) // escreve
```

| Chamada | Compila? |
|---|---|
| `fazerBarulho(cachorros)` | ✅ |
| `fazerBarulho(gatos)` | ✅ |
| `fazerBarulho(objects)` | ❌ Object é pai de Animal, não filho |
| `adotarCachorros(cachorros)` | ✅ |
| `adotarCachorros(animais)` | ✅ Animal é pai de Cachorro |
| `adotarCachorros(gatos)` | ❌ Gato é irmão de Cachorro, não pai |
| `add` dentro do `fazerBarulho` | ❌ com `extends` não se adiciona nada |

**Aprendizados**
- **Generics trazem o erro do tempo de execução para o tempo de compilação.**
- `List<String>` **não é** `List<Object>`, mesmo String sendo filha de Object.
- **PECS:** *Producer Extends, Consumer Super*. `extends` para ler, `super` para escrever.
- Passar uma lista para um método **não cria uma cópia**: o método altera a lista original.
- Uma sugestão automática da IDE pode resolver o erro e destruir o propósito do código genérico. É preciso ler antes de aceitar.

---

## Três tipos de problema

Ao longo da trilha, todo resultado inesperado foi classificado em:

| Tipo | Exemplo da trilha |
|---|---|
| **Erro de compilação** | `Paciente` passado para o `maior` com `Comparable` |
| **Exceção** | `ConcurrentModificationException`, `NoSuchElementException` |
| **Comportamento silencioso** | `poll()` retornando `null`, `peek()` em loop infinito, Set recusando duplicados |

## Como executar

Abra o projeto no IntelliJ IDEA e execute as classes de teste de cada pacote.