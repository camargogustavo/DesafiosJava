package entregas.domain;

public enum TipoEntrega {
    NORMAL(1.0),
    EXPRESSA(1.5);

    private final double multiplicador;

    TipoEntrega(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public double getMultiplicador() {
        return multiplicador;
    }
}
