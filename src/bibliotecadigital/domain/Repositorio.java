package bibliotecadigital.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Repositorio<T> {
    private List<T> itens = new ArrayList<>();

    public void adicionar(T item) {
        itens.add(item);

    }

    public <R> List<R> transformar(Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : itens) {
            result.add(function.apply(t));
        }
        return result;
    }


    public List<T> listarTodos() {
        return Collections.unmodifiableList(itens);
    }

    public List<T> filtrar(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : itens) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }



    public Optional<T> buscarPrimeiro(Predicate<T> regra) {
        for (T t : itens) {
            if (regra.test(t)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public void removerSe(Predicate<T> regra) {
        itens.removeIf(regra::test);
    }

}