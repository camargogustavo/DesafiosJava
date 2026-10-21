package refrescar.domain;

public class Triangulo extends FormaGeometrica {
    private double altura;
    private double base;

    public Triangulo(double altura, double base) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        double area = ((base * altura) / 2);
        return area;
    }
}