package lambdas.test;

import lambdas.dominio.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncionarioTest {
    public static void main(String[] args) {
        List<Funcionario> funcionarioList = new ArrayList<>();
        funcionarioList.add(new Funcionario("Ana", "TI", 7500, true));
        funcionarioList.add(new Funcionario("Bruno", "RH", 4200, true));
        funcionarioList.add(new Funcionario("Carla", "TI", 9800, false));
        funcionarioList.add(new Funcionario("Diego", "Vendas", 3900, true));
        funcionarioList.add(new Funcionario("Elisa", "RH", 5600, false));
        funcionarioList.add(new Funcionario("Fabio", "TI", 4800, true));

        List<Funcionario> ativos = filtrar(funcionarioList, Funcionario::isAtivo);
        System.out.println(ativos);

        List<Funcionario> somenteTI = filtrar(funcionarioList, f -> f.getSetor().equals("TI"));
        System.out.println(somenteTI);

        List<Funcionario> salariosAcima5000 = filtrar(funcionarioList, f -> f.getSalario() > 5000);
        System.out.println(salariosAcima5000);

        List<String> somenteNomes = transformar(funcionarioList, Funcionario::getNome);
        System.out.println(somenteNomes);

        List<Double> salariosComAumento = transformar(funcionarioList, f -> f.getSalario() * 1.10);
        System.out.println(salariosComAumento);

        List<String> nomeSetor = transformar(funcionarioList, f -> String.format("%s (%s)", f.getNome(), f.getSetor()));
        System.out.println(nomeSetor);

        List<String> nomeAtivos = transformar(ativos, Funcionario::getNome);
        System.out.println(nomeAtivos);

        List<String> nomesAtvios1 = transformar(filtrar(funcionarioList, Funcionario::isAtivo), Funcionario::getNome);
        System.out.println(nomesAtvios1);

        executar(funcionarioList, System.out::println);
    }

    private static <T> List<T> filtrar(List<T> lista, Predicate<T> predicate) {
        List<T> resultado = new ArrayList<>();
        for (T t : lista) {
            if (predicate.test(t)) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    private static <T, R> List<R> transformar(List<T> lista, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : lista) {
            result.add(function.apply(t));
        }

        return result;
    }

    private static <T> void executar(List<T> lista, Consumer<T> acao){
        for (T t : lista) {
            acao.accept(t);
        }
    }
}
