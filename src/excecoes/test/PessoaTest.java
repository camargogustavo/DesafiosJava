package excecoes.test;

import excecoes.domain.Pessoa;
import excecoes.exception.IdadeInvalidaException;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        try{
            p1.definirIdade(0);
        }catch (IdadeInvalidaException e){
            System.out.println(e.getMessage());
        }
    }
}
