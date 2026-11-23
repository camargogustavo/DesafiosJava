package parametrizacao.test;

import parametrizacao.domain.Carro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarroTest {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("prata", "Onix", 2021, 75000));
        carros.add(new Carro("vermelho", "HB20", 2019, 62000));
        carros.add(new Carro("preto", "Corolla", 2023, 145000));
        carros.add(new Carro("vermelho", "Kwid", 2022, 58000));
        carros.add(new Carro("prata", "Civic", 2018, 98000));
        carros.add(new Carro("branco", "Gol", 2016, 39000));

        for (Carro carro : carros) {
            System.out.println(carro);
        }
        System.out.println();

        System.out.println(filter(carros, car -> car.getCor().equals("vermelho")));
        System.out.println(filter(carros, car -> car.getAno() > 2020));
        System.out.println(filter(carros, car -> car.getPreco() <= 60000));
        System.out.println(filter(carros, car -> car.getCor().equals("prata") && car.getPreco() > 80000));
        System.out.println(filter(carros, new Predicate<Carro>(){
            @Override
            public boolean test(Carro carro) {
                return carro.getPreco() <= 60000;
            }
        }));
    }

    public static List<Carro> filter(List<Carro> carros, Predicate<Carro> predicate) {
        List<Carro> filterCars = new ArrayList<>();
        for (Carro carro : carros) {
            if (predicate.test(carro)) {
                filterCars.add(carro);
            }
        }
        return filterCars;
    }


}
