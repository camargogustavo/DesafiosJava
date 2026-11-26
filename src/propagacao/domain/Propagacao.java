package Propagação.domain;

import Propagação.error.OperacaoInvalidaException;

public class Propagacao {
    public void metodoA() throws OperacaoInvalidaException{
        metodoB();
    }

    public void metodoB() throws OperacaoInvalidaException{
        metodoC();
    }

    public void metodoC() throws OperacaoInvalidaException {
        throw new OperacaoInvalidaException("Operação inválida detectada no metodoC");
    }
}
