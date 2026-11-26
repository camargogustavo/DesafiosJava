package fixacaoenum.test;

import fixacaoenum.domain.*;
import fixacaoenum.inter.Vendavel;

public class TamanhoTest {
    static String sugestao(TamanhoBebida tamanho){
        return switch (tamanho){
            case PEQUENO -> "Para matar a sede";
            case MEDIO -> "Para acompanhar o lanche";
            case GRANDE -> "Para dividir";
        };
    }
    public static void main(String[] args) {
        Bebida bebida= new Bebida("Suco", TamanhoBebida.GRANDE);
        Lanche lanche = new Lanche("X-Burguer", 25, true);
        Sobremesa sobremesa = new Sobremesa("Pudim", 12);
        Pedido pedido = new Pedido();


        pedido.adicionar(bebida);
        pedido.adicionar(lanche);
        pedido.adicionar(sobremesa);

        for (TamanhoBebida tamanho : TamanhoBebida.values()) {
            System.out.println(tamanho + ": " + sugestao(tamanho));
        }
        System.out.println();

        for (Vendavel item : pedido.listarItens()){
            System.out.println(item.resumo());
        }

        System.out.println(pedido.getTotalFormatado());
    }
}
