package entregas.domain;

public class Caminhao extends EntregaBase  {
    private static final double VALOR_POR_KM = 3.5;
    private static final double TAXA_FIXA = 50.0;

    public Caminhao(TipoEntrega tipoEntrega, double km) {
        super(tipoEntrega, km);
    }

    @Override
    public double calcularFrete() {
        return (getKm() * VALOR_POR_KM + TAXA_FIXA) * getTipoEntrega().getMultiplicador();
    }

}
