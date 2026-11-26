package propagacao.test;

import propagacao.domain.Propagacao;
import propagacao.exception.OperacaoInvalidaException;

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
