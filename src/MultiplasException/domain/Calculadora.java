package MultiplasException.domain;

import MultiplasException.error.DivisaoPorZeroException;

public class Calculadora {
    public double dividir(double a, double b) throws DivisaoPorZeroException {
        if (b == 0 ){
            throw new DivisaoPorZeroException("Divisor nao pode ser 0");
        }
        return a/b;
    }
}
