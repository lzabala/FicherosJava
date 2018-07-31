import java.io.*;

/**
 * Dados los siguientes datos de empleados guardalos en un fichero llamado "employees.dat"
 * utilizando acceso aleatorio a ficheros
 */
public class WriteRandomAccessFile {
  public static void main(String[] args)throws IOException {

    File file = new File("./out/production/FicherosJava/employees.dat");
    RandomAccessFile raf = new RandomAccessFile(file,"rw");

    String[] names = {"Nicolás","Javier","Daniel","Pedro","Juan Antonio"};
    String[] surnames = {"Fernández","Gil","Ramos","Drake","Gómez"};
    int[] dept = {2,2,6,4,6};
    Double[] salary = {1000.00,1800.50,700.30,2500.00,1000.00};
    StringBuffer nameBuffer;
    StringBuffer surnameBuffer;

    for (int i = 0; i < 5; i++) {
      raf.writeInt(i+1);
      nameBuffer = new StringBuffer(names[i]);
      surnameBuffer = new StringBuffer(surnames[i]);

      nameBuffer.setLength(15);
      surnameBuffer.setLength(10);

      raf.writeChars(nameBuffer.toString());
      raf.writeChars(surnameBuffer.toString());

      raf.writeInt(dept[i]);

      raf.writeDouble(salary[i]);
    }

    raf.close();


  }
}
