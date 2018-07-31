import java.io.File;

/**
 * Realiza un programa que liste el contenido de un directorio. El nombre del directorio se pasará
 * como parámetro desde la línea de comandos
 *
 * */
public class ShowFilesArgs {
    public static void main(String[] args) {
        System.out.println("Ficheros en el directorio actual:");
        String directory = args[0];
        File f = new File(directory);
        String[] files = f.list();

        for(int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}