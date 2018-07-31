import java.io.File;

/**
 * Realiza un programa que liste el contenido de un directorio y muestre: nombre, lectura, escritura, tamaño y si
 * es directorio o fichero. El nombre del directorio se pasará
 * como parámetro desde la línea de comandos
 *
 * */
public class ShowPropertiesOfFiles {
    public static void main(String[] args) {
        System.out.println("Ficheros en el directorio actual:");
        String directory = args[0];
        File folder = new File(directory);
        String[] files = folder.list();

        for(int i = 0; i < files.length; i++) {

            File file = new File(files[i]);
            System.out.print("Nombre: " + file.getName() + " |");
            System.out.print("Lectura: " + file.canRead() + " |");
            System.out.print("Escritura: " + file.canWrite() + " |");
            System.out.print("Tamaño: " + file.length() + " |");
            if(file.isDirectory() && !file.isFile()) {
                System.out.print("Tipo: Directorio |");
            }
            else{
                System.out.println("Tipo: Fichero |");
            }
        }
    }
}