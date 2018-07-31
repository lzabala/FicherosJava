import java.io.*;

public class WriteSerializeObj {

  public static void main(String[] args) throws IOException {
    PersonSerializable person;
    PersonSerializable personRead;

    File file = new File("./out/production/FicherosJava/myPeople.dat");
    FileOutputStream fileout = new FileOutputStream(file);
    ObjectOutputStream oos = new ObjectOutputStream(fileout);

    String[] names = {"Leandro","Hernán","Irene","Roberto","Graciela"};
    int[] ages = {36,1,36,63,60};

    for (int i = 0; i < names.length; i++) {
      person = new PersonSerializable(names[i],ages[i],i+1);
      oos.writeObject(person);
    }

    oos.close();

    System.out.println("Datos de personas insertados en el fichero...");

    FileInputStream filein = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(filein);

    try {
      while (true){
        personRead = (PersonSerializable) ois.readObject();
        System.out.println("nombre: " + personRead.getName() + ", edad: " + personRead.getAge());
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (EOFException eof){
      ois.close();
    }

  }
}
