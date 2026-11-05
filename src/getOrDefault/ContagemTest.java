package getOrDefault;

import iterator.domain.Tarefa;

import java.util.*;

public class ContagemTest {
    public static void main(String[] args) {
        List<Tarefa> listaTarefas = new ArrayList<>();
        listaTarefas.add(new Tarefa("Estudar Java", true, 3));
        listaTarefas.add(new Tarefa("Limpar a casa", false, 2));
        listaTarefas.add(new Tarefa("Academia", false, 3));
        listaTarefas.add(new Tarefa("Lavar Louça", false, 1));
        listaTarefas.add(new Tarefa("Fazer Almoço", true, 2));
        listaTarefas.add(new Tarefa("Tarefa Faculdade", false, 1));

        Map<Integer, Integer> contagem = new TreeMap<>();
        System.out.println(contagem.getOrDefault(5, 0));
        System.out.println(contagem.size());
        for(Tarefa tarefa : listaTarefas){
            int prioridade = tarefa.getPrioridade();
                    contagem.put(prioridade, contagem.getOrDefault(prioridade, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> mapImprimir : contagem.entrySet()){
            System.out.println("Prioridade: " + mapImprimir.getKey() + "  Quantidade: "+  mapImprimir.getValue());
        }
    }
}
