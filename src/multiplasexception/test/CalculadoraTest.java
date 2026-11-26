package multiplasexception.test;

import multiplasexception.domain.Calculadora;
import multiplasexception.exception.DivisaoPorZeroException;

public class CalculadoraTest {
    public static void main(String[] args) {
        Calculadora c1 = new Calculadora();

        try{
            System.out.println(c1.dividir(4,2));
        } catch (DivisaoPorZeroException e) {
            System.err.println(e.getMessage());
        }

        try{
            System.out.println(c1.dividir(4,0));
        } catch (DivisaoPorZeroException e) {
            System.err.println(e.getMessage());
        }
    }
}
