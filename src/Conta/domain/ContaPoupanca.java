package Conta.domain;

public class ContaPoupanca {
    private double saldo;

    public ContaPoupanca(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){
        if(valor > 0 ) {
            this.saldo += valor;
        }
    }

    @Override
    public String toString() {
        return "--- Informacoes da Conta ---" + "\n" +
                "Saldo: " + saldo;
    }
}
