package bibliotecadigital.teste;

import bibliotecadigital.domain.Genero;
import bibliotecadigital.domain.Livro;
import bibliotecadigital.domain.Repositorio;

import java.util.*;

public class LivroTeste {
    public static void main(String[] args) {
        System.out.println("====== ETAPA 1 ======");
        List<Livro> livros = new ArrayList<>();
        Repositorio<Livro> repositorioLivros = new Repositorio<>();
        livros.add(new Livro("001", "Clean Code", "Robert Martin", 2008, Genero.TECNOLOGIA, true));
        livros.add(new Livro("002", "Dom Casmurro", "Machado de Assis", 1899, Genero.FICCAO, true));
        livros.add(new Livro("003", "Sapiens", "Yuval Harari", 2011, Genero.HISTORIA, false));
        livros.add(new Livro("004", "Effective Java", "Joshua Bloch", 2018, Genero.TECNOLOGIA, true));
        livros.add(new Livro("005", "1984", "George Orwell", 1949, Genero.FICCAO, true));
        livros.add(new Livro("006", "Refactoring", "Martin Fowler", 2018, Genero.TECNOLOGIA, false));
        livros.add(new Livro("004", "Effective Java", "Joshua Bloch", 2018, Genero.TECNOLOGIA, true));
        livros.add(new Livro("007", "O Cortiço", "Aluísio Azevedo", 1890, Genero.FICCAO, true));
        livros.add(new Livro("008", "Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881, Genero.FICCAO, true));

        Set<Livro> livrosUnicos = new LinkedHashSet<>(livros);
        livrosUnicos.forEach(repositorioLivros::adicionar);

        repositorioLivros.listarTodos().forEach(System.out::println);
        System.out.println("Livros cadastrados: " + repositorioLivros.listarTodos().size());

        System.out.println("====== ETAPA 2 ======");


        List<Livro> livrosDisponiveis = repositorioLivros.filtrar(Livro::isDisponivel);
        livrosDisponiveis.forEach(System.out::println);
        System.out.println("====== ETAPA 2.1 ======");

        List<Livro> tecnologiaAPartirDe2015 = repositorioLivros.filtrar(l -> l.getAno() >= 2015 && l.getGenero() == Genero.TECNOLOGIA);
        tecnologiaAPartirDe2015.forEach(System.out::println);

        System.out.println("====== ETAPA 3 ======");

        List<String> somenteTitulos = repositorioLivros.transformar(Livro::getTitulo);
        Collections.sort(somenteTitulos);
        somenteTitulos.forEach(System.out::println);

        List<String> livrosFormatados = repositorioLivros.transformar(l -> String.format("%s - %s (%d)", l.getTitulo(), l.getAutor(), l.getAno()));
        livrosFormatados.forEach(System.out::println);

        System.out.println("====== ETAPA 4 ======");

        List<Livro> livrosMachadoDeAssis = repositorioLivros.filtrar(l -> l.getAutor().equals("Machado de Assis"));
        livrosMachadoDeAssis.forEach(l -> l.setDisponivel(false));

        repositorioLivros.listarTodos().forEach(System.out::println);

        System.out.println("====== ETAPA 5 ======");

        Optional<Livro> buscarPorISBN = repositorioLivros.buscarPrimeiro(l -> l.getIsbn().equals("004"));
        Optional<Livro> buscarPorISBN999 = repositorioLivros.buscarPrimeiro(l -> l.getIsbn().equals("999"));
        String titulo004 = buscarPorISBN.map(Livro::getTitulo).orElse("Não encontrado");
        String titulo999 = buscarPorISBN999.map(Livro::getTitulo).orElse("Não encontrado");
        System.out.println(titulo004);
        System.out.println(titulo999);

        List<Livro> disponiveisAgora = repositorioLivros.filtrar(Livro::isDisponivel);
        Optional<Livro> buscarLivroMaisAntigo = livroMaisAntigo(disponiveisAgora);
        String tituloMaisAntigo = buscarLivroMaisAntigo.map(Livro::getTitulo).orElse("Não encontrado");
        System.out.println(tituloMaisAntigo);

        System.out.println("====== ETAPA 6 ======");

        TreeMap<String, Integer> contagemGeneros = new TreeMap<>();

        for (Livro livro : repositorioLivros.listarTodos()) {
            String descricao = livro.getGenero().getDescricao();
            contagemGeneros.put(descricao, contagemGeneros.getOrDefault(descricao, 0) + 1);
        }

        for (Map.Entry<String, Integer> entrada : contagemGeneros.entrySet()) {
            int quantidade = entrada.getValue();
            String palavra = (quantidade == 1) ? "livro" : "livros";
            System.out.println(entrada.getKey() + ": " + quantidade + " " + palavra);
        }

        System.out.println("====== ETAPA 7 ======");

        repositorioLivros.listarTodos().forEach(System.out::println);

        repositorioLivros.removerSe(l -> l.getAno() < 1950);
        System.out.println("----------------------");

        repositorioLivros.listarTodos().forEach(System.out::println);


    }

    private static Optional<Livro> livroMaisAntigo(List<Livro> lista) {
        if (lista.isEmpty()) {
            return Optional.empty();
        }
        Livro menor = lista.get(0);
        for (Livro livro : lista) {
            if (livro.getAno() < menor.getAno()) {
                menor = livro;
            }
        }
        return Optional.of(menor);
    }


}
