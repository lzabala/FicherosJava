import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Realiza un programa que escriba en un fichero llamado frasesMatrix.txt
 * el texto: Yo sólo puedo mostrarte la puerta, tú eres quien la tiene que atravesar.
 * Si ejecutas el programa dos veces, ¿Qué ocurre? ¿Cómo lo solucionamos?
 * */

public class WriteFileJava {
  public static void main(String[] args) throws IOException {
    File file = new File("./out/production/FicherosJava/frasesMatrix.txt");
    FileWriter fw = new FileWriter(file,true);
    String str = "Yo sólo puedo mostrarte la puerta, tú eres quien la tiene que atravesar.";
    fw.write(str);

    fw.append('\n');
    fw.close();

  }
}
