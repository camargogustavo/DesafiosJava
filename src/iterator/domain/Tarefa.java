package iterator.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class itaratorTest {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Iterator<Integer> it = numeros.iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (n % 2 == 0) {
                numeros.remove(Integer.valueOf(n));
            }
        }
        System.out.println(numeros);
    }
}
