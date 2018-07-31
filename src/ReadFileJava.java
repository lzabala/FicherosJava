import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Realiza un programa que lea el fichero readFileJava.java
 * */

public class ReadFileJava {
  public static void main(String[] args) throws IOException{
    File file = new File("./src/ReadFileJava.java");

    FileReader fr = new FileReader(file);

    int i;

    while((i = fr.read()) != -1){
      System.out.print((char) i);
    }

    fr.close();
  }
}
