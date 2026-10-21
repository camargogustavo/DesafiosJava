package entregas.domain;

public class Moto implements Entregavel {
    private static final double VALOR_POR_KM = 2.0;
    private TipoEntrega tipoEntrega;   // repetido
    private double km;                 // repetido

    public Moto(TipoEntrega tipoEntrega, double km) {
        if (tipoEntrega == null) {                       // repetido
            throw new IllegalArgumentException("O tipo da entrega nao pode ser null");
        }
        if (km <= 0) {                                   // repetido
            throw new IllegalArgumentException("O valor dos km não pode ser 0 ou negativo");
        }
        this.tipoEntrega = tipoEntrega;
        this.km = km;
    }

    @Override
    public double calcularFrete() {
        return km * VALOR_POR_KM * tipoEntrega.getMultiplicador();
    }

    @Override
    public String toString() {                           // repetido
        return String.format("Moto (%s) - Frete para %,.2f km: R$ %.2f", tipoEntrega, km, calcularFrete());
    }
}

}
