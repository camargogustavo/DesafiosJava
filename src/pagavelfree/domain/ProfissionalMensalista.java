package PagavelFree.domain;


public class ProfissionalMensalista extends Profissional {
    private double salarioFixo;

    public ProfissionalMensalista(String nome, double salarioFixo) {
        super(nome);
        this.salarioFixo = salarioFixo;
    }


    @Override
    public double calcularPagamento() {
        return salarioFixo;
    }
}
