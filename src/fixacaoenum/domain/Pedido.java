package fixacaoenum.domain;

import fixacaoenum.inter.Vendavel;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Vendavel> itens = new ArrayList<>();

    public void adicionar(Vendavel item) {
        itens.add(item);
    }

    public List<Vendavel> listarItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (Vendavel item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }

    public String getTotalFormatado() {
        return String.format("Total do pedido: %.2f", calcularTotal());
    }


}
