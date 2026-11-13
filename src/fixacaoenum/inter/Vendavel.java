package fixacaoenum.inter;

public interface Vendavel {
    double calcularPreco();
    String getDescricao();

    default String resumo() {
        return String.format("%s - R$ %.2f", getDescricao(), calcularPreco());
    }
}