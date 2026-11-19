package classesinternas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Carrinho {
    private String cliente;
    private List<Produto> produtos = new ArrayList<>();

    public Carrinho(String cliente) {
        this.cliente = cliente;
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public void ordenarPorPreco() {
        produtos.sort(new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                return Double.compare(o1.getPreco(), o2.getPreco());
            }
        });
    }

    public double totalComDesconto(double percentual) {
        double valorTotal = 0;
        class Calculadora {
            double aplicar(double valor) {
                double desconto = valor * (percentual / 100);
                return valor - desconto;
            }
        }
        for (Produto item : produtos) {
            valorTotal += item.getPreco();
        }
        Calculadora calculadora = new Calculadora();
        return calculadora.aplicar(valorTotal);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getCliente() {
        return cliente;
    }

    public class Resumo {

        public void mostrar() {
            System.out.println("Carrinho de " + getCliente() + ": " + produtos.size() + " produtos ");
        }
    }

    public static class Produto {
        private String nome;
        private double preco;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        @Override
        public String toString() {
            return String.format("--- Informações do Produto --- %nNome: %s %nPreço: %,.2f%n", getNome(), getPreco());
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

    }


}
