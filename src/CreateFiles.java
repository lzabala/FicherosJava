import java.io.File;
import java.io.IOException;

/**
 * Realiza un programa que cree un directorio ("myFiles").
 * Crea dos ficheros ("fichero1", "fichero2")
 * Renombra "fichero2" -> "ficheroRenombrado"
 * Lista el contenido de "MyFiles"
 * Borra "fichero1"
 * Lista el contenido de "MyFiles"
 * */
public class CreateFiles {
    public static void main(String[] args) {
        System.out.println("Ficheros en el directorio actual:");
        String path = "/Users/leandro/Downloads/";
        File myDirectory = new File(path + "MyFiles");

        File f1 = new File(path + "/MyFiles/fichero1.txt");
        File f2 = new File(path +"/MyFiles/fichero2.txt");

        myDirectory.mkdir();

        for(int i = 0; i < myDirectory.list().length; i++) {
            System.out.println(myDirectory.list()[i]);
        }

        try{
            if(f1.createNewFile()){
                System.out.println("fichero1.txt creado correctamente.");
            }
            else{
                System.out.println("fichero1.txt no se ha podido crear");
            }

            if(f2.createNewFile()){
                System.out.println("fichero2.txt creado correctamente.");
            }
            else{
                System.out.println("fichero2.txt no se ha podido crear");
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println("Ficheros en el directorio actual:");
        for(int i = 0; i < myDirectory.list().length; i++) {
            System.out.println(myDirectory.list()[i]);
        }

        f2.renameTo(new File(myDirectory,"ficheroRenombrado.txt"));

        System.out.println("Ficheros en el directorio actual después del rename:");
        for(int i = 0; i < myDirectory.list().length; i++) {
            System.out.println(myDirectory.list()[i]);
        }

        f1.delete();

        System.out.println("Ficheros en el directorio actual después del delete:");
        for(int i = 0; i < myDirectory.list().length; i++) {
            System.out.println(myDirectory.list()[i]);
        }
    }
}
