package generics.dominio;

public class Livros implements Comparable<Livros> {
    private String nome;
    private String autor;
    private int ano;

    public Livros(String nome, String autor, int ano) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Informações do Livro" + "\n"+
                "Nome: " + nome + "\n" +
                "Autor: " + autor + "\n" +
                "Ano: " + ano + "\n" +
                "------------------------" + "\n";
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public int compareTo(Livros livro) {
        return this.nome.compareTo(livro.getNome());
    }


}
