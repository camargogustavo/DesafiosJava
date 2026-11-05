package iterator.domain;


public class Tarefa {
    private String descricao;
    private boolean concluida = false;
    private int prioridade;

    public Tarefa(String descricao, boolean concluida, int prioridade) {
        this.descricao = descricao;
        this.concluida = concluida;
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "InformaçÕes da Tarefa" + "\n" +
                "Descricao: " + descricao + "\n" +
                "Concluida:" + concluida + "\n" +
                "Prioridade: " + prioridade + "\n" +
                "----------------------";
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public int getPrioridade() {
        return prioridade;
    }
}
