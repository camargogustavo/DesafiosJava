package entregas.domain;

public class Moto extends EntregaBase  {
    private static final double VALOR_POR_KM = 2.0;

    public Moto(TipoEntrega tipoEntrega, double km) {
        super(tipoEntrega, km);
    }

    @Override
    public double calcularFrete() {
        return getKm() * VALOR_POR_KM * getTipoEntrega().getMultiplicador();
    }

}
