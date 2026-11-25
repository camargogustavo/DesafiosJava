package bibliotecadigital.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Repositorio<T> {
    private List<T> itens = new ArrayList<>();

    public void adicionar(T item) {
        itens.add(item);

    }

    public List<T> listarTodos() {
        return itens;
    }

    public List<T> filtar(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : itens) {
            if (predicate.test(t)) {
                result.add(t);

            }
        }
        return result;
    }

    public Optional<T> buscarPrimeiro(Predicate<T> regra) {
        List<T> result = new ArrayList<>();
        for (T t : itens) {
            if (regra.test(t)) {
                result.add(t);
            }
        }
        return Optional.of(result.get(0));

    }

    public void removerSe(Predicate<T> regra) {
        itens.removeIf(regra::test);
    }
}