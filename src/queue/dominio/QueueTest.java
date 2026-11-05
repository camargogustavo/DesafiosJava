package queue.dominio;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
//Queue
//Peek: mostra o primeiro sem tirar
//poLl: tira o primeiro e devolve
//offer: colca no fim da fila

//PriorityQueue tira o menor sempre pela ordem de comparacao

//Deque a fila de duas pontas
//push coloca no topo
//pop tira do topo
//peek retorna o topo
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> fila = new ArrayDeque<>();
        fila.offer("Alana");
        fila.offer("Gustavo");
        fila.offer("Fumaca");
        fila.offer("Faisca");

        System.out.println(fila.poll()); //tira e devolve o primeiro da lista
        System.out.println(fila.peek()); //mostra o primeiro sem tirar
        System.out.println(fila.poll());//tira e devolve o primeiro
        System.out.println(fila.peek());


        Queue<Integer> filaPriority = new PriorityQueue<>();

        filaPriority.offer(30);
        filaPriority.offer(10);
        filaPriority.offer(20);

        System.out.println(filaPriority.poll());
        System.out.println(filaPriority.poll());
        System.out.println(filaPriority.poll());


        Deque<String> pilha = new ArrayDeque<>();
        pilha.push("prato 1");
        pilha.push("prato 2");
        pilha.push("prato 3");

        System.out.println(pilha.pop());
        System.out.println(pilha.peek());
        System.out.println(pilha.pop());





    }
}
