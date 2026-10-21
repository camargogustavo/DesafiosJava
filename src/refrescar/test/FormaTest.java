package refrescar.test;

import refrescar.domain.Circulo;
import refrescar.domain.FormaGeometrica;
import refrescar.domain.Triangulo;

import java.util.ArrayList;
import java.util.List;

public class FormaTest {
    public static void main(String[] args) {
        List<FormaGeometrica> forma = new ArrayList<>();
        forma.add(new Circulo(1));
        forma.add(new Triangulo(1,2));

        for (FormaGeometrica f : forma){
            System.out.println(f.calcularArea());
        }
    }
}
