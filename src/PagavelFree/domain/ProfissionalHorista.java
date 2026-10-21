package PagavelFree.domain;

public class ProfissionalHorista extends Profissional{
    private double valorHora = 20;
    private double horasTrabalhadas;

    public ProfissionalHorista(String nome, double horasTrabalhadas) {
        super(nome);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularPagamento() {
        return valorHora * horasTrabalhadas;
    }
}
