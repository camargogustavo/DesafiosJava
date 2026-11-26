package ValidarSaque.error;

public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException (String mensagem){
        super(mensagem);
    }
}