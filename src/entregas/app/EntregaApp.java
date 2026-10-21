package entregas.app;

import entregas.domain.Caminhao;
import entregas.domain.Entregavel;
import entregas.domain.Moto;
import entregas.domain.TipoEntrega;

import java.util.ArrayList;
import java.util.List;

public class EntregaApp {
    public static void main(String[] args) {
        List<Entregavel> entregas = new ArrayList<>();

        entregas.add(new Caminhao(TipoEntrega.EXPRESSA, 10));
        entregas.add(new Caminhao(TipoEntrega.NORMAL, 10));
        entregas.add(new Moto(TipoEntrega.NORMAL, 10));
        entregas.add(new Moto(TipoEntrega.EXPRESSA, 10));

        for (Entregavel entregavel : entregas) {
            System.out.println(entregavel);
        }
    }
}
