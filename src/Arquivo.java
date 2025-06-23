import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Arquivo {

    public static File criarArquivo(String nome) {

        try {
            File arquivo = new File(nome + ".txt");

            if (!arquivo.createNewFile()) {
                System.out.println("\nArquivo " + arquivo.getName() + " já existe!");
                return arquivo;
            }

            System.out.println("\nArquivo " + arquivo.getName() + " criado com sucesso!");
            return arquivo;
        } catch (IOException e) {
            System.out.println("\nOcorreu um erro ao criar o arquivo!");
        }

        return null;
    }

    public static void escreverArquivo(File arquivo, String texto) {
        try {
            FileWriter escritor = new FileWriter(arquivo, true);

            escritor.write(texto);
            escritor.close();

            System.out.println("\nTexto escrito com sucesso no arquivo " + arquivo.getName() + "!");
        } catch (IOException e) {
            System.out.println("\nOcorreu um erro ao escrever no arquivo " + arquivo.getName() + "!");
        }
    }

    public static void lerArquivo(File arquivo) {
        try {
            Scanner leitor = new Scanner(arquivo);

            System.out.println();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
            }

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nO arquivo " + arquivo.getName() + " não foi encontrado!");
        }
    }

    public static void excluirArquivo(File arquivo) {
        if (arquivo.delete())
            System.out.println("\nArquivo " + arquivo.getName() + " excluído com sucesso!");

        else
            System.out.println("\nOcorreu um erro ao excluir o arquivo " + arquivo.getName() + "!");
    }

    public static void infoArquivo(File arquivo) {
        if (!arquivo.exists()) {
            System.out.println("\nO arquivo " + arquivo.getName() + " não existe!");
            return;
        }

        System.out.println("\nNome: " + arquivo.getName());
        System.out.println("Caminho: " + arquivo.getAbsolutePath());
        System.out.println("Leitura: " + arquivo.canRead());
        System.out.println("Escrita: " + arquivo.canWrite());
        System.out.println("Tamanho: " + arquivo.length());
    }

}
