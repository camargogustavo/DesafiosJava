#Sistema de Validação de Saque Bancário

## 📋 Problema

Um caixa eletrônico precisa validar saques antes de processá-los — recusando valores inválidos ou acima do saldo disponível — e registrar cada tentativa (bem-sucedida ou não) num arquivo de log.

## 🧠 Conceitos aplicados

- **Exceções checked customizadas** — `ValorInvalidoException` e `SaldoInsuficienteException` estendem `Exception` (não `RuntimeException`), forçando quem chama `sacar()` a tratar esses casos explicitamente.
- **`throw` / `throws`** — `sacar()` declara as exceções que pode lançar na assinatura, e lança cada uma no cenário correto.
- **Captura em múltiplos `catch`** — o `main` trata cada tipo de exceção separadamente, exibindo a mensagem de erro correspondente.
- **`try-with-resources`** — o log em arquivo usa essa sintaxe para garantir que o `BufferedWriter` seja fechado automaticamente, mesmo se ocorrer erro na escrita.
- **Separação de responsabilidades** — `sacar()` cuida só da validação e da regra de negócio; `registrarLog(String mensagem)` cuida só de escrever no arquivo, sem saber nada sobre saques ou validação.

## 📁 Estrutura das classes

| Classe | Responsabilidade |
|---|---|
| `ContaBancaria` | Guarda nome e saldo; valida e processa saques; registra tentativas no log |
| `ValorInvalidoException` | Exceção checked para valores de saque `<= 0` |
| `SaldoInsuficienteException` | Exceção checked para saques acima do saldo disponível |
| `SaqueTest` | Classe com `main`, lê o valor do saque via `Scanner` e trata os cenários |

## ▶️ Como rodar

```bash
javac *.java
java SaqueTest
```

O programa vai pedir um valor de saque no console e gravar cada tentativa (sucesso ou erro) em `arquivos_log.txt`, no modo append (sem apagar tentativas anteriores).

## 💡 Principal aprendizado

Perceber que `registrarLog()` não deveria validar nada — a primeira versão duplicava a lógica de `if (valor <= 0)` que já existia em `sacar()`. Um método deve ter uma responsabilidade única: receber uma mensagem pronta e escrevê-la, deixando quem chama decidir o conteúdo.