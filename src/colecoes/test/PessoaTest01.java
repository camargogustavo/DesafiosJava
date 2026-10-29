package colecoes.test;

import colecoes.domain.Pessoa;

import java.util.HashSet;
import java.util.Set;

public class PessoaTest01 {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Gustavo", "123123123");
        Pessoa p2 = new Pessoa("Alana", "123123123");

        Set<Pessoa> listaPessoa = new HashSet<>();
        System.out.println(listaPessoa.add(p1));
        System.out.println(listaPessoa.add(p2));
        for (Pessoa p : listaPessoa) {
            System.out.println(p.getNome());
        }

    }
}
