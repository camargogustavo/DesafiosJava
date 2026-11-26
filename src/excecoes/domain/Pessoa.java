package Excecoes.domain;

import Excecoes.exception.IdadeInvalidaException;

public class Pessoa {
    private int idade;

    public void definirIdade(int idadeInserida) throws IdadeInvalidaException {
        if (idadeInserida < 0 || idadeInserida > 100){
            throw new IdadeInvalidaException("Idade inserida é invalida. | Valor inserido: " +idadeInserida);
        } else {
            this.idade = idadeInserida;
        }
    }

    @Override
    public String toString() {
        return "Informacoes da Pessoa" + "\n" +
                "Idade: " + idade;
    }
}
