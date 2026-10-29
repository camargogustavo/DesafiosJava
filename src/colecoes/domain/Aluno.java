package colecoes.domain;

import java.util.Objects;


public class Aluno {
    private String nome;
    private String cpf;
    private int idade;

    public Aluno(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Informacoes do Aluno" + "\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Idade: " + idade + "\n" +
                "-------------------";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(cpf, aluno.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }
}
