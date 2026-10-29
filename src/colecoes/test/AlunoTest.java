package colecoes.test;

import colecoes.domain.Aluno;
import colecoes.domain.AlunoIdadeComparator;
import colecoes.domain.AlunoNomeComparator;

import java.util.*;

public class AlunoTest {

    private static String descobrirFaixaEtaria(int idade) {
        if (idade > 30) {
            return "Aluno acima de 30 anos";
        } else if (idade >= 18) {
            return "Aluno entre 18 a 30 anos";
        } else {
            return "Aluno menor que 18 anos";
        }
    }

    private static void imprimir(Collection<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== ETAPA 1: Inscrições recebidas ===");
        List<Aluno> inscricoes = new ArrayList<>();
        inscricoes.add(new Aluno("Gustavo", "111111111", 20));
        inscricoes.add(new Aluno("Alana", "222222222", 37));
        inscricoes.add(new Aluno("Andre", "333333333", 38));
        inscricoes.add(new Aluno("Fumaca", "444444444", 2));
        inscricoes.add(new Aluno("Faisca", "555555555", 1));
        inscricoes.add(new Aluno("Fogo", "222222222", 5));
        System.out.println("Total de inscrições: " + inscricoes.size());


        System.out.println("\n=== ETAPA 2: Alunos únicos ===");
        Set<Aluno> alunosUnicos = new LinkedHashSet<>(inscricoes);
        System.out.println("Total de alunos únicos: " + alunosUnicos.size());
        imprimir(alunosUnicos);


        List<Aluno> alunosOrdenados = new ArrayList<>(alunosUnicos);

        System.out.println("\n=== ETAPA 3a: Ordenados por nome ===");
        alunosOrdenados.sort(new AlunoNomeComparator());
        imprimir(alunosOrdenados);

        System.out.println("\n=== ETAPA 3b: Ordenados por idade ===");
        alunosOrdenados.sort(new AlunoIdadeComparator());
        imprimir(alunosOrdenados);


        System.out.println("\n=== ETAPA 4: Contagem por faixa etária ===");
        Map<String, Integer> contagemPorFaixa = new TreeMap<>();

        for (Aluno aluno : alunosUnicos) {
            String faixa = descobrirFaixaEtaria(aluno.getIdade());

            if (contagemPorFaixa.containsKey(faixa)) {
                contagemPorFaixa.put(faixa, contagemPorFaixa.get(faixa) + 1);
            } else {
                contagemPorFaixa.put(faixa, 1);
            }
        }

        for (Map.Entry<String, Integer> contagem : contagemPorFaixa.entrySet()) {
            System.out.println(contagem.getKey() + " - " + contagem.getValue() + " aluno(s)");
        }
    }
}