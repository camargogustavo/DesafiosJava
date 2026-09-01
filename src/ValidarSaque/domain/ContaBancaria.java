package ValidarSaque.domain;

import ValidarSaque.error.SaldoInsuficienteException;
import ValidarSaque.error.ValorInvalidoException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContaBancaria {
    private String nome;
    private double saldo;

    public ContaBancaria(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0){
            throw new ValorInvalidoException("Valor do saque é invalido: "+ valor);
        } else if (valor > saldo) {
            throw new SaldoInsuficienteException("Valor do saldo é insuficiente | Saldo disponivel:  " +this.saldo);
        }
        saldo -= valor;
        System.out.println("Saque de: " +  valor + "realizado com sucesso!");
    }

    public void registrarLog(String mensagem) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("arquivos_log.txt", true))) {
            bf.write(mensagem);
            bf.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no log: " + e.getMessage());
        }
    }
}
