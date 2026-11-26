package NIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ContadorArquivos {
    public static void main(String[] args) {
        Path pasta = Path.of("C:\\Users\\Gustavo\\OneDrive\\Desktop\\DesafiosJava");
        int contador = 0;
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(pasta, "*.txt")){
            for (Path arquivo : stream ){
                System.out.println(arquivo.getFileName());
                contador += 1 ;
            }
        } catch (IOException e) {
            System.err.println("Não foi possível ler o diretório: " + e.getMessage());
        }
        System.out.println(contador);
    }
}
