package controleDeEstoque.app;

import controleDeEstoque.domain.Estoque;
import controleDeEstoque.domain.Produto;
import controleDeEstoque.exception.EstoqueInsuficienteException;
import controleDeEstoque.exception.ProdutoNaoEncontradoException;

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
