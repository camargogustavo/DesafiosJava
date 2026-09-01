package FolhaPagamento.domain;

import FolhaPagamento.inter.Bonificavel;
import FolhaPagamento.inter.Cargo;

public class FuncionarioComissado extends Funcionario implements Bonificavel {
    private double totalVendas;

    public FuncionarioComissado(String nome, double salarioBase, Cargo cargo, double totalVendas) {
        super(nome, salarioBase, cargo);
        this.totalVendas = totalVendas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Bonus: "+ calcularBonusAnual();

    }

    @Override
    public double calcularBonusAnual() {
        return totalVendas * 0.1;
    }

    @Override
    public double calcularSalario() {
        return (getSalarioBase() + (totalVendas * 0.05));
    }


}