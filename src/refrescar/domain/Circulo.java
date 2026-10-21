package refrescar.domain;

public class Circulo extends FormaGeometrica {
    private double raio;
    private static double PI = 3.14;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        double area = (PI*(raio*raio));
        return area;
    }
}
