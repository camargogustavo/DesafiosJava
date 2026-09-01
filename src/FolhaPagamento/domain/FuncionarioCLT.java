package FolhaPagamento.domain;


import FolhaPagamento.inter.Cargo;

public class FuncionarioCLT extends Funcionario {
    public FuncionarioCLT(String nome, double salarioBase, Cargo cargo) {
        super(nome, salarioBase, cargo);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }
}