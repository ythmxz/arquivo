import java.io.File;

public class App {

    public static void main(String[] args) {
        File meuArquivo = Arquivo.criarArquivo("teste");
        Arquivo.escreverArquivo(meuArquivo, "Olá, mundo!");
        Arquivo.lerArquivo(meuArquivo);
        Arquivo.infoArquivo(meuArquivo);
    }

}
