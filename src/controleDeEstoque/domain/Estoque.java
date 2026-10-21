package controleDeEstoque.domain;

import controleDeEstoque.exception.EstoqueInsuficienteException;
import controleDeEstoque.exception.ProdutoNaoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Produto> produtos = new HashMap<>();

    public void adicionar(Produto p) {
        if (!produtos.containsKey(p.getNome())) {
            produtos.put(p.getNome(), p);
        } else {
            Produto existente = produtos.get(p.getNome()); // busca o produto existente pelo nome
            existente.adicionarQuantidade(p.getQuantidade());

        }
    }

   public void remover(String nome, int quantidade) throws EstoqueInsuficienteException, ProdutoNaoEncontradoException {
        if (!produtos.containsKey(nome)){
            throw new ProdutoNaoEncontradoException("Produto nao encontrado: "+nome);
        }

        Produto existente = produtos.get(nome);

        if (quantidade > existente.getQuantidade()){
            throw new EstoqueInsuficienteException("Não Foi possivel remover essa quantidade. - Pedido: " + quantidade +" Disponivel: "+existente.getQuantidade());
        }

        existente.removerQuantidade(quantidade);
    }

    public void listar() {
        for (Produto produto : produtos.values()) {
            System.out.println(produto);
        }
        System.out.println("\n");
    }
    public void nomes() {
        for (String produto : produtos.keySet()) {
            System.out.println(produto);
        }
    }
}
