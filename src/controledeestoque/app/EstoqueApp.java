package controledeestoque.app;

import controledeestoque.domain.Estoque;
import controledeestoque.domain.Produto;
import controledeestoque.exception.EstoqueInsuficienteException;
import controledeestoque.exception.ProdutoNaoEncontradoException;

public class EstoqueApp {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        estoque.adicionar(new Produto("Caneta", 3, 20));
        estoque.adicionar(new Produto("Borracha", 5, 20));
        estoque.adicionar(new Produto("Lapis", 1.5, 100));

        estoque.listar();

        try{
            estoque.remover("Caneta", 11);
        } catch (EstoqueInsuficienteException | ProdutoNaoEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        try{
            estoque.remover("Borracha", 21);
        } catch (EstoqueInsuficienteException | ProdutoNaoEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        try{
            estoque.remover("lapis", 11);
        } catch (EstoqueInsuficienteException | ProdutoNaoEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        estoque.adicionar(new Produto("Lapis", 1.5, 100));
        estoque.listar();

    }

}
