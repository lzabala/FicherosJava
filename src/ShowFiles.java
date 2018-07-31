import java.io.*;
/**
 * Realiza un programa que liste el contenido de un directorio
 *
 * */
public class ShowFiles {
    public static void main(String[] args) {
        System.out.println("Ficheros en el directorio actual:");
        File folder = new File("/Users/leandro/Downloads");
        String[] files = folder.list();

        for(int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}