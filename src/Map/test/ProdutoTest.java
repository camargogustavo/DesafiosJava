package Map.test;

import Map.domain.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoTest {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Map<String, List<Produto>> agrupamento = new HashMap<>();

        produtos.add(new Produto("celular", "eletronico"));
        produtos.add(new Produto("notebook", "eletronico"));
        produtos.add(new Produto("banana", "fruta"));
        produtos.add(new Produto("maca", "fruta"));
        produtos.add(new Produto("desinfetante", "limpeza"));
        produtos.add(new Produto("detergente", "limpeza"));

        for (Produto infoProduto : produtos) {
            String categoria = infoProduto.getCategoria();
            if (agrupamento.containsKey(categoria)) {
                List<Produto> listaExistente = agrupamento.get(categoria);
                listaExistente.add(infoProduto);
            } else {
                List<Produto> novaLista = new ArrayList<>();
                novaLista.add(infoProduto);
                agrupamento.put(categoria, novaLista);
            }
        }
        for (Map.Entry<String, List<Produto>> entrada : agrupamento.entrySet()){
            System.out.println(entrada.getKey() +" : "+entrada.getValue());
        }
    }
}
