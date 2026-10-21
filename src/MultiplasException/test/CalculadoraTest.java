package MultiplasException.test;

import MultiplasException.domain.Calculadora;
import MultiplasException.error.DivisaoPorZeroException;

import java.util.ArrayList;

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
