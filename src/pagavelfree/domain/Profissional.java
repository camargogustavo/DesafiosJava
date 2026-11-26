package PagavelFree.domain;

import PagavelFree.inter.Pagavel;

public abstract class Profissional implements Pagavel  {
    private String nome;

    public Profissional(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Informacoes do Profissional" + "\n" + "Nome: " + nome;
    }

    @Override
    public  abstract double calcularPagamento();
}
