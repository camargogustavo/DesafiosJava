package ValidarSaque.test;


import ValidarSaque.domain.ContaBancaria;
import ValidarSaque.error.SaldoInsuficienteException;
import ValidarSaque.error.ValorInvalidoException;
import java.nio.file.Path;
import java.util.Scanner;

public class SaqueTest {
    public static void main(String[] args) {
        ContaBancaria c1 = new ContaBancaria("Gustavo", 1000);
        Path arq = Path.of("arquivos_log.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor para o saque");
        double valor = input.nextDouble();

        try {
            c1.sacar(valor);
            c1.registrarLog("Saque no valor: " + valor + " realizado com sucesso" );
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
            c1.registrarLog("Saldo insuficiente! | Valor do saque:  " + valor);
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
            c1.registrarLog("Valor insuficiente! | Valor do saque:  " + valor);
        }







    }
}
