package generics.domain;

public abstract class Animal {
    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Informações do Animal" + "\n" +
                "Nome:" + nome;
    }

    public abstract String emitirSom();


}
