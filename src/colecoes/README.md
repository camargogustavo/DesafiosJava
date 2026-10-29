# Desafio 4 — Inscrições em Cursos

Desafio de revisão do bloco de **Coleções** do curso Maratona Java (DevDojo).

## O problema

Uma escola recebe inscrições pelo site. Muitos alunos clicam duas vezes no botão de inscrição, e a mesma inscrição chega repetida. O sistema precisa:

1. Receber todas as inscrições, inclusive as repetidas.
2. Remover os alunos duplicados, mantendo a ordem de chegada.
3. Ordenar os alunos por nome e por idade.
4. Contar quantos alunos existem em cada faixa etária.

Dois alunos são considerados o mesmo aluno quando têm o **mesmo CPF**.

## Conceitos praticados

| Conceito | Onde foi usado |
|---|---|
| `List` / `ArrayList` | Guardar todas as inscrições, aceitando duplicados |
| `Set` / `LinkedHashSet` | Remover duplicados mantendo a ordem de inserção |
| `equals()` e `hashCode()` | Definir que dois alunos são iguais pelo CPF |
| `Comparator` | Duas regras de ordenação separadas (nome e idade) |
| `Map` / `HashMap` | Contagem de alunos por faixa etária |
| `Map.Entry` e `entrySet()` | Percorrer chave e valor do Map ao mesmo tempo |
| `Collection` como parâmetro | Um único método `imprimir()` que aceita List e Set |

## Estrutura do projeto

```
colecoes
├── domain
│   ├── Aluno.java
│   ├── AlunoNomeComparator.java
│   └── AlunoIdadeComparator.java
└── test
    └── AlunoTest.java
```

- **Aluno**: atributos `nome`, `cpf` e `idade`. Sobrescreve `equals()` e `hashCode()` usando apenas o CPF.
- **AlunoNomeComparator**: ordena em ordem alfabética (A → Z).
- **AlunoIdadeComparator**: ordena do mais novo para o mais velho, usando `Integer.compare()`.
- **AlunoTest**: executa as quatro etapas do desafio.

## Etapas

### Etapa 1 — List com duplicados
Seis inscrições são adicionadas a uma `List`. Uma delas repete o CPF de outro aluno. Como a `List` aceita duplicados, o total é **6**.

### Etapa 2 — Remover duplicados com Set
A lista é copiada para um `LinkedHashSet`:

```java
Set<Aluno> alunosUnicos = new LinkedHashSet<>(inscricoes);
```

O total passa a ser **5**. O Set **recusa** o aluno repetido e mantém o que chegou primeiro. O `LinkedHashSet` foi escolhido porque preserva a ordem de inserção.

### Etapa 3 — Ordenação
Os alunos únicos voltam para uma `List` e são ordenados com dois `Comparator` diferentes:

```java
alunosOrdenados.sort(new AlunoNomeComparator());
alunosOrdenados.sort(new AlunoIdadeComparator());
```

- **Por nome:** Alana, Andre, Faisca, Fumaca, Gustavo
- **Por idade:** Faisca (1), Fumaca (2), Gustavo (20), Alana (37), Andre (38)

### Etapa 4 — Contagem por faixa etária
Cada aluno único é classificado em uma faixa pelo método `descobrirFaixaEtaria()`, e a contagem é feita em um `Map<String, Integer>` com o padrão `containsKey` / `get` / `put`.

| Faixa | Quantidade |
|---|---|
| Menor que 18 anos | 2 |
| Entre 18 e 30 anos | 1 |
| Acima de 30 anos | 2 |

## O que aprendi

- **Set recusa, Map substitui.** Ao receber um elemento repetido, o Set ignora o novo e mantém o antigo. O Map, ao receber uma chave repetida, troca o valor antigo pelo novo.
- **`equals()` e `hashCode()` andam juntos.** O `hashCode()` indica onde procurar e o `equals()` confirma se é igual. Sobrescrever só o `equals()` faz o `HashSet` aceitar duplicados sem nenhum erro.
- **Sem `equals()` sobrescrito, a comparação é pelo endereço na memória**, e não pelo conteúdo do objeto.
- **Comparable define uma ordem só, dentro da classe. Comparator permite várias, fora dela.**
- **`get()` de uma chave inexistente devolve `null`.** Guardar esse retorno em um `int` gera `NullPointerException`, por isso o `get()` só é chamado depois de confirmar a chave com `containsKey()`.
- **No parâmetro, pedir o tipo mais geral possível.** Usar `Collection` permite que o mesmo método receba List ou Set.
- **Testar valores de fronteira** (18 e 30) evita erros de `>` e `>=`.

## Como executar

Abra o projeto no IntelliJ IDEA e execute a classe `colecoes.test.AlunoTest`.