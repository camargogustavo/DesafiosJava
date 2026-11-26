package leituraEscrita.domain;

import java.io.*;
import java.util.List;

public class EscreveLer {
    public void escrever(List<String> mensagens){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("dados.txt", true))){
            for (String mensagem : mensagens){
                bw.write(mensagem);
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public void lerArquivo(){
        try(BufferedReader br = new BufferedReader(new FileReader("dados.txt"))){
            String linhas;
            while ((linhas = br.readLine()) != null){
                System.out.println(linhas);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
