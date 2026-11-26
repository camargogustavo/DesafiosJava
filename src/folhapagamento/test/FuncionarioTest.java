package folhapagamento.test;

import java.util.ArrayList;

import folhapagamento.domain.Funcionario;
import folhapagamento.domain.FuncionarioCLT;
import folhapagamento.domain.FuncionarioComissado;
import folhapagamento.inter.Cargo;

public class FuncionarioTest {
    public static void main(String[] args) {
        ArrayList<Funcionario> func = new ArrayList<>();
        func.add(new FuncionarioComissado("Gustavo", 7500, Cargo.SENIOR, 10));
        func.add(new FuncionarioComissado("Alana", 10500, Cargo.SENIOR, 100));
        func.add(new FuncionarioCLT("Vitao", 1500, Cargo.SENIOR));
        func.add(new FuncionarioCLT("Monikas", 1000, Cargo.SENIOR));

        for (Funcionario f : func ){
            System.out.println(f);
        }
    }
}