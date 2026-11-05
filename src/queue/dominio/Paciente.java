package queue.dominio;


public class Paciente{
    private String nome;
    private int prioridade;

    public Paciente(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Informações do Paciente" + "\n" +
                "Nome: " + nome + "\n" +
                "Prioridade: " + prioridade + "\n" +
                "---------------------" + "\n";
    }

    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }
}
