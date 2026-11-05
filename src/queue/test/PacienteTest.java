package queue.test;

import queue.dominio.Paciente;
import queue.dominio.PrioridadeComparator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class PacienteTest {
    public static void main(String[] args) {
        Queue<Paciente> fila = new ArrayDeque<>();
        fila.offer(new Paciente("Alana", 2));
        fila.offer(new Paciente("Andre", 5));
        fila.offer(new Paciente("Gustavo", 1));
        fila.offer(new Paciente("Fumaca", 4));
        fila.offer(new Paciente("Faisca", 3));

        while (!fila.isEmpty()) {
            Paciente atentido = fila.poll();
            System.out.println("Atendido: " + atentido);
        }
        System.out.println("===============");
        System.out.println("===============");

        Queue<Paciente> filaPrioridade = new PriorityQueue<>(new PrioridadeComparator());
        filaPrioridade.offer(new Paciente("Angelita", 2));
        filaPrioridade.offer(new Paciente("Edson", 5));
        filaPrioridade.offer(new Paciente("Rafael", 1));
        filaPrioridade.offer(new Paciente("Felipe", 4));
        filaPrioridade.offer(new Paciente("Theo", 3));

        System.out.println(filaPrioridade);

        while (!filaPrioridade.isEmpty()) {
            Paciente paciente = filaPrioridade.poll();
            System.out.println("Atendendo paciente: " + paciente);
        }

        Deque<String> pilha = new ArrayDeque<>();
        pilha.push("Digitou A");
        pilha.push("Digitou B");
        pilha.push("Apagou B");
        pilha.push("Digitou C");

        System.out.println("Removeu: " + pilha.pop());
        System.out.println("Removeu: " + pilha.pop());
        for (String entrada : pilha) {
            System.out.println(entrada);
        }

    }
}
