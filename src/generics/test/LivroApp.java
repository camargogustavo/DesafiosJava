    package generics.test;

    import generics.dominio.Livros;

    import java.util.*;


    public class LivroApp {
        private static <T> void imprimir(Collection<T> lista) {
            for (T item : lista) {
                System.out.println(item);
            }
        }

        public static void main(String[] args) {
            List<Livros> livros = new ArrayList<>();
            livros.add(new Livros("48 leis do Poder", "Robert Greene", 2001));
            livros.add(new Livros("Mais Esperto que o Diabo", "Napoleao Hill", 2002));
            livros.add(new Livros("O Principe", "Nikolas Maquiavel", 2003));
            livros.add(new Livros("Arte da GUerra", "Nikolas Maquiavel", 2004));

            Collections.sort(livros);

            imprimir(livros);
            System.out.println("========================================");

            TreeSet<Livros> livrosTreeSet = new TreeSet<>(livros);
            livrosTreeSet.add(new Livros("O Principe", "Nikolas Maquiavel", 2005));


            System.out.println(livrosTreeSet.size());

            imprimir(livrosTreeSet);
            System.out.println(livrosTreeSet.first());
            System.out.println(livrosTreeSet.last());

            TreeMap<Integer, String> livrosPorAno = new TreeMap<>();
            livrosPorAno.put(2003, "O principe - Edicao especial");
            for (Livros livro : livros){
                livrosPorAno.put(livro.getAno(), livro.getNome());
            }

            for (Map.Entry<Integer, String> entrada : livrosPorAno.entrySet()){
                System.out.println("Ano " + entrada.getKey() + " - Nome:" + entrada.getValue() );
            }
            System.out.println(livrosPorAno.size());

            System.out.println(livrosPorAno.firstKey());
            System.out.println(livrosPorAno.lastKey());
            System.out.println(livrosPorAno.headMap(2003));// headMap imprimi todas chaves menores que


        }
    }
