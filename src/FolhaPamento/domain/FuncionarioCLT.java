package FolhaPamento.domain;


import FolhaPamento.inter.Cargo;

public class FuncionarioCLT extends Funcionario {
    public FuncionarioCLT(String nome, double salarioBase, Cargo cargo) {
        super(nome, salarioBase, cargo);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }
}