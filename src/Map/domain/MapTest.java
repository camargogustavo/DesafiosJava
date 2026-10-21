package Map.domain;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> contadorNomes = new HashMap<>();
        String[] nomes = {"Ana", "Bruno", "Ana", "Carlos", "Ana", "Bruno"};
        for (String nome : nomes){
            if (contadorNomes.containsKey(nome)){
                int valorAtual = contadorNomes.get(nome);
                contadorNomes.put(nome, valorAtual + 1);
            }else {
                contadorNomes.put(nome, 1);
            }
        }

        for (Map.Entry<String,Integer> entrada : contadorNomes.entrySet()){
            System.out.println(entrada.getKey() + ":" + entrada.getValue());
        }



    }
}
