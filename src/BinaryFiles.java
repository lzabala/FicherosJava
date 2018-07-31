import java.io.*;

/***
 * Crea un programa que simule el comportamiento de cp, el primer argumento es la ruta del fichero a copiar,
 * el segundo argumento es la ruta del fichero copia.
 * Utiliza las clases DataOutputStream/DataInputStream para crear un fichero con los nombres y la edad de 5 personas
 * contenidos en un array, luego imprime el contenido por pantalla
 */

public class BinaryFiles {

  public static void main(String[] args) throws IOException {

    FileInputStream filein = null;
    FileOutputStream fileout = null;
    try {
      filein = new FileInputStream(new File("/Users/leandro/Downloads/acceptacioLeandro.pdf"));
      fileout = new FileOutputStream(new File("/Users/leandro/Downloads/copia.pdf"));

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int i;
    while ((i = filein.read()) != -1){
      fileout.write(i);
    }
    filein.close();
    fileout.close();
  }
}
