package lambdas.dominio;

public class Funcionario {
    private String nome;
    private String setor;
    private double salario;
    private boolean ativo;

    public Funcionario(String nome, String setor, double salario, boolean ativo) {
        this.nome = nome;
        this.setor = setor;
        this.salario = salario;
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | R$ %,.2f | %s", nome, setor, salario, ativo ? "ativo" : "inativo");
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    public double getSalario() {
        return salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
