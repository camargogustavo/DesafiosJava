package lambdas.test;

import lambdas.dominio.Funcionario;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncionarioTest02 {
    public static void main(String[] args) {
        List<Funcionario> funcionarioList = new ArrayList<>();
        funcionarioList.add(new Funcionario("Ana", "TI", 7500, true));
        funcionarioList.add(new Funcionario("Bruno", "RH", 4200, true));
        funcionarioList.add(new Funcionario("Carla", "TI", 9800, false));
        funcionarioList.add(new Funcionario("Diego", "Vendas", 3900, true));
        funcionarioList.add(new Funcionario("Elisa", "RH", 5600, false));
        funcionarioList.add(new Funcionario("Fabio", "TI", 4800, true));

        System.out.println(funcionarioList);

        List<String> somenteSetor = transformar(funcionarioList, Funcionario::getSetor);
        System.out.println(somenteSetor);

        List<Funcionario> salarioMaiorQue = filtrar(funcionarioList, f -> f.getSetor().equals("TI") && f.getSalario() > 5000);
        System.out.println(salarioMaiorQue);
        List<String> nomesSalariosMaiorQue = transformar(salarioMaiorQue, Funcionario::getNome);
        System.out.println(nomesSalariosMaiorQue);


        List<Double> salariosComAumento = transformar(funcionarioList, f -> f.getSalario() * 1.05);
        executar(salariosComAumento, System.out::println);


        List<Funcionario> somenteRH = filtrar(funcionarioList, f -> f.getSetor().equals("RH"));
        executar(somenteRH, f -> f.setAtivo(false));
        System.out.println(somenteRH);

        List<Funcionario> acima10000 = filtrar(funcionarioList, f -> f.getSalario() > 10000);
        boolean existeAlguem = !acima10000.isEmpty();
        System.out.println(existeAlguem);

        String nome = maiorSalario(funcionarioList).map(Funcionario::getNome).orElse("lista vazia");
        System.out.println(nome);

        String nome2 = maiorSalario(new ArrayList<>()).map(Funcionario::getNome).orElse("lista vazia");
        System.out.println(nome2);

        Optional<Funcionario> buscarPorBruno = buscarPorNome(funcionarioList, "Bruno");
        System.out.println(funcionarioList);
        buscarPorBruno.ifPresent(f -> f.setSalario(f.getSalario()*1.10));
        System.out.println(buscarPorBruno);

        Optional<Funcionario> buscarPorZe = buscarPorNome(funcionarioList, "Ze");
        buscarPorZe.ifPresent(f -> f.setSalario(f.getSalario()*1.10));
        buscarPorZe.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Zé nao encontrado"));

        Optional<Funcionario> buscarCarla = buscarPorNome(funcionarioList, "Carla").filter(Funcionario::isAtivo);
        String resultadoCarla = buscarCarla.map(Funcionario::getNome).orElse("inexistente");
        System.out.println(resultadoCarla);

    }

    private static Optional<Funcionario> buscarPorNome(List<Funcionario> lista, String nome) {
        List<Funcionario> encontrados = filtrar(lista, f -> f.getNome().equals(nome));
        if (encontrados.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(encontrados.get(0));
    }

    private static Optional<Funcionario> maiorSalario(List<Funcionario> lista) {
        if (lista.isEmpty()) {
            return Optional.empty();
        }
        Funcionario maior = lista.get(0);
        for (Funcionario funcionario : lista) {
            if (funcionario.getSalario() > maior.getSalario()) {
                maior = funcionario;
            }
        }
        return Optional.of(maior);


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

    private static <T> void executar(List<T> lista, Consumer<T> acao) {
        for (T t : lista) {
            acao.accept(t);
        }
    }
}
