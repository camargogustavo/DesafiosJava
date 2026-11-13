package fixacaoenum.dominio;

public enum TamanhoBebida {
    PEQUENO(300, 5.000),
    MEDIO(500, 7.00),
    GRANDE(700, 9.00);
    private final int milimitros;
    private final double preco;

    TamanhoBebida(int milimitros, double preco) {
        this.milimitros = milimitros;
        this.preco = preco;
    }

    public int getMilimitros() {
        return milimitros;
    }

    public double getPreco() {
        return preco;
    }
    
    public String getDescricao(){
        return String.format("%s (%d ml)",name(), milimitros);
    }
}
