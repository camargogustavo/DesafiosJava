package Propagação.test;

import Propagação.domain.Propagacao;
import Propagação.error.OperacaoInvalidaException;

public class PropagacaoTest {
    public static void main(String[] args){
        Propagacao p1 = new Propagacao();
        try {
            p1.metodoA();
        } catch (OperacaoInvalidaException e) {
            System.err.println(e.getMessage());
        }
    }
}
