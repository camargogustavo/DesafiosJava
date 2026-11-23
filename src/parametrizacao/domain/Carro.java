package parametrizacao.domain;

public class Carro {
    private String cor;
    private String modelo;
    private int ano;
    private double preco;

    public Carro(String cor, String modelo, int ano, double preco) {
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %d | R$ %,.2f" , getModelo(), getCor(), getAno(), getPreco());
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }
}
