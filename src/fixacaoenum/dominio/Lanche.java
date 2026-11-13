package fixacaoenum.dominio;

import fixacaoenum.inter.Vendavel;

public class Lanche implements Vendavel {
    private String nome;
    private double precoBase;
    private boolean comBatata;
    private static final double PRECO_BATATA = 8.00;

    public Lanche(String nome, double precoBase, boolean comBatata) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.comBatata = comBatata;
    }

    @Override
    public double calcularPreco() {
        if (comBatata){
            return getPrecoBase()+PRECO_BATATA;
        }
        return getPrecoBase();
    }

    @Override
    public String getDescricao() {
        if (comBatata){
            return getNome()+" com Batata";
        }
        return getNome();
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public boolean isComBatata() {
        return comBatata;
    }



}
