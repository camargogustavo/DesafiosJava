package classesinternas.test;

import classesinternas.Carrinho;

public class CarrinhoTest {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho("Gustavo");
        Carrinho.Resumo resumo = carrinho.new Resumo();

        carrinho.adicionar(new Carrinho.Produto("Energetico", 12.50));
        carrinho.adicionar(new Carrinho.Produto("Sabonete", 5.20));
        carrinho.adicionar(new Carrinho.Produto("Bala", 0.40));
        carrinho.adicionar(new Carrinho.Produto("Cereal", 9.99));
        carrinho.adicionar(new Carrinho.Produto("Agua", 2.60));

        resumo.mostrar();
        carrinho.ordenarPorPreco();


        for (Carrinho.Produto produto : carrinho.getProdutos()){
            System.out.println(produto);
        }

        double total = carrinho.totalComDesconto(10);
        System.out.println(String.format("Total com desconto:  R$ %,.2f", total));
    }
}
