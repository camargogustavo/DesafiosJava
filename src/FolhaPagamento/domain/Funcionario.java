package FolhaPagamento.domain;

import FolhaPagamento.inter.Cargo;

public abstract class Funcionario {
    private String nome;
    private double salarioBase;
    private Cargo cargo;

    public Funcionario(String nome, double salarioBase, Cargo cargo) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Nome: " + nome + " | Cargo: " + cargo + " | Salario: " + calcularSalario();
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public Cargo getCargo() {
        return cargo;
    }
}