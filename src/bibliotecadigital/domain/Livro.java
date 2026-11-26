package bibliotecadigital.domain;

import java.util.Objects;

public class Livro implements Comparable<Livro> {
    private String isbn;
    private String titulo;
    private String autor;
    private int ano;
    private Genero genero;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor, int ano, Genero genero, boolean disponivel) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.genero = genero;
        this.disponivel = disponivel;
    }

    @Override
    public int compareTo(Livro o) {
        return titulo.compareTo(o.getTitulo());
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %d | %s | $s", getTitulo(), getAutor(), getAno(), getGenero().getDescricao(), isDisponivel() ? "Disponivel" : "emprestado");
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(isbn, livro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public Genero getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
}
