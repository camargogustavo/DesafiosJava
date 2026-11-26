package fixacaoenum.domain;

import fixacaoenum.inter.Vendavel;

public class Bebida implements Vendavel {
    private String nome;
    private TamanhoBebida tamanhoBebida;

    public Bebida(String nome, TamanhoBebida tamanhoBebida) {
        this.nome = nome;
        this.tamanhoBebida = tamanhoBebida;
    }

    public String getNome() {
        return nome;
    }

    public TamanhoBebida getTamanhoBebida() {
        return tamanhoBebida;
    }

    @Override
    public double calcularPreco() {
        return getTamanhoBebida().getPreco();
    }

    @Override
    public String getDescricao() {
        return getNome() + " " + tamanhoBebida.getDescricao();
    }
}
