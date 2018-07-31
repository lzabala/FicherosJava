import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Realiza un programa que escriba en un fichero llamado escribeLineas.txt
 * Escribe 10 lineas separadas para un salto de linea cada una.
 * Basándote en el ejemplo utiliza la clase PrintWriter para escribir en un fichero
 * usando la función print y println
 */

public class WriteLineFileJava {

  public static void main(String[] args) {

    try {
      BufferedWriter file = new BufferedWriter(new FileWriter("./out/production/FicherosJava/escribeLineas.txt"));
      for (int i = 0; i < 10; i++) {
        file.write("Fila número: " + i);
        file.newLine();
      }
      file.close();
    } catch (IOException e) {
      System.out.println("error de E/S");
    }
  }
}
