package pagavelfree.test;

import pagavelfree.domain.Profissional;
import pagavelfree.domain.ProfissionalFreelancer;
import pagavelfree.domain.ProfissionalHorista;
import pagavelfree.domain.ProfissionalMensalista;

import java.util.ArrayList;
import java.util.List;

public class ProfissionalTest {
    public static void main(String[] args) {
        List<Profissional> profissionals = new ArrayList<>();
        profissionals.add(new ProfissionalMensalista("Monikao", 1621));
        profissionals.add(new ProfissionalHorista("Vitao", 120));
        profissionals.add(new ProfissionalFreelancer("Gustavo", 10000));

        for (Profissional p : profissionals){
            System.out.println(p);
            System.out.println("Pagamento: " + p.calcularPagamento());
        }
    }
}
