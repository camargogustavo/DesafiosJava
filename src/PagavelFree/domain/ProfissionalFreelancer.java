package PagavelFree.domain;

public class ProfissionalFreelancer extends Profissional {
    private double valorProjeto;

    public ProfissionalFreelancer(String nome, double valorProjeto) {
        super(nome);
        this.valorProjeto = valorProjeto;
    }

    @Override
    public double calcularPagamento() {
        return valorProjeto;
    }
}
