package iterator.test;

import iterator.domain.Tarefa;

import java.util.*;

public class TarefaApp {
    private static <T> void imprimir(Collection<T> lista) {
        for (T item : lista) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<Tarefa> listaTarefas = new ArrayList<>();
        listaTarefas.add(new Tarefa("Estudar Java", true, 3));
        listaTarefas.add(new Tarefa("Limpar a casa", false, 2));
        listaTarefas.add(new Tarefa("Academia", false, 3));
        listaTarefas.add(new Tarefa("Lavar Louça", false, 1));
        listaTarefas.add(new Tarefa("Fazer Almoço", true, 2));
        listaTarefas.add(new Tarefa("Tarefa Faculdade", false, 3));
        List<Tarefa> copia = new ArrayList<>(listaTarefas);
        Map<Integer, Integer> contagem = new HashMap<>();

        imprimir(listaTarefas);

        Iterator<Tarefa> it = listaTarefas.iterator();
        int tarefasRemovidasContador = 0;
        while (it.hasNext()) {
            Tarefa tarefa = it.next();
            if (tarefa.isConcluida()) {
                it.remove();
                System.out.println("Removida: " + tarefa.getDescricao());
                tarefasRemovidasContador++;
            }
        }

        System.out.println("Quantas tarefas foram removidas: " + tarefasRemovidasContador);
        System.out.println("---------------");
        System.out.println("---------------");

        imprimir(listaTarefas);

        System.out.println("---------------");
        System.out.println("---------------");

        listaTarefas.removeIf(t -> t.getPrioridade() == 3);

        imprimir(listaTarefas);

        System.out.println("---------------");
        System.out.println("---------------");


        for (Tarefa entrada : copia) {
            if (entrada.isConcluida()) {
                copia.remove(entrada);
            }
        }
        for (Tarefa tarefa : listaTarefas){
            int prioridade = tarefa.getPrioridade();
            contagem.put(prioridade, contagem.getOrDefault(prioridade, 0) + 1);
        }
    }
}
