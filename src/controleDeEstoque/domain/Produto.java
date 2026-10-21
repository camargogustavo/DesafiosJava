package controleDeEstoque.domain;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O produto deve conter um nome");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        if (quantidade <= 0){
            throw new IllegalArgumentException("A quantidade adicionada tem que ser maior que 0");
        }
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        if (quantidade <= 0){
            throw new IllegalArgumentException("A quantidade removida tem que ser maior que 0");
        }
        this.quantidade -= quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return String.format("Produto: (%s) - Preço: %.2f - Quantidade: %d ", getNome(), getPreco(), getQuantidade());
    }
}
