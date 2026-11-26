# Sistema de Folha de Pagamento

## 📋 Problema

Uma empresa tem diferentes tipos de funcionário, cada um com uma regra diferente de cálculo de salário e bônus. O sistema precisa representar essas diferenças de forma organizada, sem duplicar lógica entre os tipos.

## 🧠 Conceitos aplicados

- **Classe abstrata** (`Funcionario`) — define o contrato comum (nome, salário base, cargo) e um método abstrato `calcularSalario()` que cada subtipo implementa à sua maneira.
- **Herança** — `FuncionarioCLT` e `FuncionarioComissado` estendem `Funcionario`, reaproveitando atributos e comportamento comum.
- **Interface** (`Bonificavel`) — só `FuncionarioComissado` implementa, já que bônus anual não se aplica a todo funcionário.
- **Enum** (`Cargo`) — representa os cargos possíveis (`JUNIOR`, `PLENO`, `SENIOR`) de forma segura, sem usar Strings soltas.
- **Polimorfismo** — a lista `ArrayList<Funcionario>` guarda objetos de tipos diferentes, e cada um executa sua própria versão de `calcularSalario()` e `toString()` automaticamente.
- **`toString()` em cadeia** — `FuncionarioComissado` sobrescreve `toString()` reaproveitando `super.toString()` da classe pai, evitando duplicar a formatação de nome/cargo/salário.

## 📁 Estrutura das classes

| Classe | Responsabilidade |
|---|---|
| `Funcionario` | Classe abstrata base — nome, salário base, cargo, `toString()` |
| `FuncionarioCLT` | Funcionário com salário fixo |
| `FuncionarioComissado` | Funcionário com salário + comissão sobre vendas, elegível a bônus |
| `Bonificavel` | Interface com `calcularBonusAnual()` |
| `Cargo` | Enum com os cargos possíveis |
| `FuncionarioTest` | Classe com `main`, monta a lista e imprime os dados |

## ▶️ Como rodar

```bash
javac *.java
java FuncionarioTest
```

## 💡 Principal aprendizado

Perceber quando duplicar código (`instanceof` + cast manual no `main`) pode ser substituído por polimorfismo de verdade — deixando o próprio objeto decidir como se apresentar (`toString()`), em vez de o código externo perguntar "que tipo você é?" toda hora.