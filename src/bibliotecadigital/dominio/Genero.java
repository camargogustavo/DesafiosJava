package bibliotecadigital.dominio;

public enum Genero {
    HISTORIA("História"),
    FICCAO("Ficção"),
    TECNOLOGIA("Tecnologia");
    private final String genero;

    Genero(String genero) {
        this.genero = genero;
    }
    public String getDescricao() {
        return genero;
    }
}
