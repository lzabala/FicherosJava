import java.io.*;

/**
 * Realiza un programa que lea el fichero ReadLineFileJava.java y que lo haga por lineas
 * */

public class ReadLineFileJava {

  public static void main(String[] args){

    try {
      BufferedReader br = new BufferedReader(new FileReader("./src/ReadFileJava.java"));
      String line = "";

      while ((line = br.readLine()) != null){
        System.out.println(line);
      }
    }
    catch (FileNotFoundException fne){
      System.out.println("Fichero no encontrado");
    }
    catch (IOException ioe){
      System.out.println("Error de E/S");
    }
  }
}
