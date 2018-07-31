import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Crea un programa que reciba como parámetro el identificador del empleado a consultar
 * y que devuelva los datos del empleado por consola. Los datos son los guardados
 * en el fichero "employees.dat" generado en el ejercicio anterior.
 *
 * Crea un programa que aumente el salario de un empleado.
 * Este programa reciba 2 parámetros, el primer parámetro es el id del empleado a modificar,
 * el segundo parámetro es el incremento de salario. El resultado ha de ser primero mostror el empleado con los datos
 * actuales y después con los datos modificados.
 */

public class ReadRandomAccessFile {

  public static void main(String[] args)throws IOException {
    String param = args[0];

    int id = Integer.parseInt(param);
    int pos = 0;
    char[] name = new char[15];

    File file = new File("./employees.dat");

    RandomAccessFile raf = new RandomAccessFile(file,"r");

    if(id > 0 && id < 6){
      pos = (pos + id-1) * 66;

      if(pos >= raf.length()){
        System.out.println("id no encontrado");
      }
      else {
        raf.seek(pos);
        System.out.print("id: " + raf.readInt());

        for (int i = 0; i < 15; i++) {
          name[i] = raf.readChar();
        }

        System.out.print(", nombre: " + new String(name));
      }
    }
    else{
      System.out.println("El id introducido no es correcto");
    }
  }
}
