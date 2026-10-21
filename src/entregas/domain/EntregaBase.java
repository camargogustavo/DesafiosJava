package entregas.domain;

public abstract class EntregaBase implements Entregavel {
    private TipoEntrega tipoEntrega;
    private double km;


    public EntregaBase(TipoEntrega tipoEntrega, double km) {
        if (tipoEntrega == null) {
            throw new IllegalArgumentException("O tipo da entrega nao pode ser nulo");
        }
        if (km <= 0) {
            throw new IllegalArgumentException("O valor dos km não pode ser 0 ou negativo");
        }
        this.tipoEntrega = tipoEntrega;
        this.km = km;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public double getKm() {
        return km;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Frete para %.2f km: R$ %.2f",
                getClass().getSimpleName(), getTipoEntrega(), getKm(), calcularFrete());
    }
}


