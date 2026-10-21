package leituraEscrita.test;

import leituraEscrita.domain.EscreveLer;

import java.util.ArrayList;
import java.util.List;

public class LerEscreverTest {
    public static void main(String[] args) {
        List<String> mensagens = new ArrayList<>();
        mensagens.add("Primeira linha");
        mensagens.add("Segunda linha");
        mensagens.add("terceira linha");
        mensagens.add("Quarta linha");
        mensagens.add("Quinta linha");

        EscreveLer e1 = new EscreveLer();
        e1.escrever(mensagens);
        e1.lerArquivo();
    }
}
