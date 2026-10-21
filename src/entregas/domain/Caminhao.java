package entregas.domain;

public class Caminhao implements Entregavel {
    private static final double VALOR_POR_KM = 3.5;
    private static final double TAXA_FIXA = 50;
    private TipoEntrega tipoEntrega;   // repetido
    private double km;                 // repetido

    public Caminhao(TipoEntrega tipoEntrega, double km) {
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
        return (km * VALOR_POR_KM + TAXA_FIXA) * tipoEntrega.getMultiplicador();
    }

    @Override
    public String toString() {                           // repetido
        return String.format("Caminhao (%s) - Frete para %.2f km: R$ %.2f", tipoEntrega, km, calcularFrete());
    }
}

}
