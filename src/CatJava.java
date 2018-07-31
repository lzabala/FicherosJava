import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Realiza un programa que simule el comportamiento del comando cat. Le pasas una ruta de un fichero
 * y te muestra el contenido
 * Solo se muestra el contenido si el parametro es una ruta a un fichero, si es una carpeta muestra el texto:
 * " 'ruta' no es un fichero, es un directorio."
 * */

public class CatJava {
  public static void main(String[] args) throws IOException {
    String path = args[0];
    File f = new File(path);

    if(f.isDirectory()){
      System.out.println(f.getPath() + " no es un fichero, es un directorio");
    }
    else{
      System.out.println("El contenido del fichero " + f.getName() + " es:");

      FileReader fr = new FileReader(f);

      int i;

      while((i = fr.read()) != -1){
        System.out.print((char) i);
      }

      fr.close();
    }
  }
}
