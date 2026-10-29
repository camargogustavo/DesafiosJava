package colecoes.domain;

import java.util.Comparator;

public class AlunoIdadeComparator implements Comparator<Aluno> {
    @Override
    public int compare(Aluno i1, Aluno i2) {
        return Integer.compare(i1.getIdade(), i2.getIdade());
    }
}