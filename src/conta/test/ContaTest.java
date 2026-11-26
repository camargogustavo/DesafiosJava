package Conta.test;

import Conta.domain.ContaPoupanca;

public class ContaTest {
    public static void main(String[] args) {
        ContaPoupanca c1 = new ContaPoupanca(0);
        c1.depositar(-50);
        System.out.println(c1);
        c1.depositar(100);
        System.out.println(c1);



        





    }
}
