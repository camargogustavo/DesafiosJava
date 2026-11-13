package fixacaoenum.dominio;

import fixacaoenum.inter.Vendavel;

public class Sobremesa  implements Vendavel {
    private String nome;
    private double preco;

    public Sobremesa(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public double calcularPreco() {
        return getPreco();
    }

    @Override
    public String getDescricao() {
        return getNome();
    }
}
