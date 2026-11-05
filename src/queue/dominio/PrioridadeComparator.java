package queue.dominio;

import java.util.Comparator;

public class PrioridadeComparator implements Comparator<Paciente> {
    @Override
    public int compare(Paciente o1, Paciente o2) {
        return Integer.compare(o2.getPrioridade(), o1.getPrioridade());
    }
}