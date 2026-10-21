package Serializable.test;

import Serializable.domain.Usuario;

import java.io.*;

public class UsuarioTest {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Gustavo", "gustavo@gmail.com");

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuario.dat"))){
            oos.writeObject(usuario);
        } catch (IOException e) {
            System.err.println("Erro ao serializar: " + e.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuario.dat"))){
            Usuario usuarrioRecupercao = (Usuario) ois.readObject();
            System.out.println(usuarrioRecupercao);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao desserializar: " + e.getMessage());
        }
    }
}
