package generics.test;

import generics.domain.*;
import queue.domain.Paciente;
import queue.domain.PrioridadeComparator;

import java.util.Comparator;
import java.util.List;

public class RepositorioTest {
    public static void main(String[] args) {
        Repositorio<Livros> livrosRepositorio = new Repositorio<>();
        List<Integer> integers = List.of(3, 17, 8, 12);
        Repositorio<Paciente> pacienteRepositorio = new Repositorio<>();
        Repositorio<Gato> gatoRepositorio = new Repositorio<>();
        Repositorio<Cachorro> cachorroRepositorio = new Repositorio<>();
        Repositorio<Animal> animalRepositorio = new Repositorio<>();
        Repositorio<Object> objectRepositorio = new Repositorio<>();
        livrosRepositorio.adicionar(new Livros("48 leis do Poder", "Robert Greene", 2001));
        livrosRepositorio.adicionar(new Livros("Mais Esperto que o Diabo", "Napoleao Hill", 2002));
        livrosRepositorio.adicionar(new Livros("O Principe", "Nikolas Maquiavel", 2003));
        livrosRepositorio.adicionar(new Livros("Arte da GUerra", "Nikolas Maquiavel", 2004));

        pacienteRepositorio.adicionar(new Paciente("Alana", 2));
        pacienteRepositorio.adicionar(new Paciente("Andre", 5));
        pacienteRepositorio.adicionar(new Paciente("Gustavo", 1));
        pacienteRepositorio.adicionar(new Paciente("Fumaca", 4));
        pacienteRepositorio.adicionar(new Paciente("Faisca", 3));

        gatoRepositorio.adicionar(new Gato("Faisca"));
        gatoRepositorio.adicionar(new Gato("Fumaca"));

        cachorroRepositorio.adicionar(new Cachorro("Poseidon"));
        cachorroRepositorio.adicionar(new Cachorro("Zeus"));

        Livros maiorLivro = maior(livrosRepositorio.listarTodos());
        System.out.println(maiorLivro);

        Paciente maiorPaciente = maior(pacienteRepositorio.listarTodos(), new PrioridadeComparator().reversed());
        System.out.println(maiorPaciente);

        Integer maiorNumero = maior(integers);
        System.out.println(maiorNumero);

        fazerBarulho(cachorroRepositorio.listarTodos());
        fazerBarulho(gatoRepositorio.listarTodos());
        System.out.println("---------");
//        fazerbarulho(objectRepositorio.listarTodos()); erro de compilacao, pois Object é pai de Animal e não filha. Object é generico de mais
        adotarCachorros(cachorroRepositorio.listarTodos());
        adotarCachorros(animalRepositorio.listarTodos());
//        adotarCachorro(gatoRepositorio.listarTodos()); Nao compila , pois no parametro do metodo foi passado um super de cachorro e cachorro nao é igual a gato
        System.out.println("---------");
        fazerBarulho(cachorroRepositorio.listarTodos());
        System.out.println("---------");
        fazerBarulho(animalRepositorio.listarTodos());

    }
    //super é para escrever
    //extends é para ler
    private static void fazerBarulho(List<? extends Animal> lista){
        for (Animal animal : lista){
            System.out.println(animal +" - "+ animal.emitirSom());
            System.out.println();
        }
//        lista.add(new Cachorro("Rex")); metodo usa extends nao super
    }

    private static void adotarCachorros(List<? super Cachorro> lista){
        lista.add(new Cachorro("jade"));
        lista.add(new Cachorro("ruby"));
    }


    private static <T extends Comparable<T>> T maior(List<T> lista){
        T maior = lista.get(0);
        for (T item : lista){
            if (item.compareTo(maior) > 0){
                maior = item;
            }
        }
        return maior;
    }

    private static <T> T maior(List<T> lista, Comparator<T> comparador){
        T maior = lista.get(0);
        for (T item : lista){
            if (comparador.compare(item,maior) > 0){
                maior = item;
            }
        }
        return maior;
    }
}
