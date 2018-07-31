import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateEmployeeXml {
  public static void main(java.lang.String[] args) throws IOException{

    //Cargamos el fichero employees.dat para lectura
    File file = new File("./out/production/FicherosJava/employees.dat");

    RandomAccessFile raf = new RandomAccessFile(file,"r");

    //declaramos las variables para almacenar los datos del fichero
    int id, dep, pos = 0;
    Double salary;
    char names[] = new char[15];
    char surnames[] = new char[10];

    //creamos la factoria para construir documentos XML
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    try {
      //creamos el constructor
      DocumentBuilder builder = factory.newDocumentBuilder();
      //Obtenemos la implementación del DOM
      DOMImplementation implementation = builder.getDOMImplementation();
      //Creamos el documento vacío
      Document document = implementation.createDocument(null,"Employees",null);

      //asignamos la versión
      document.setXmlVersion("1.0");

      //Recorremos el documento employees.dat
      for(;;){
        //nos posicionamos en el inicio
        raf.seek(pos);
        //Obtenemos el id
        id = raf.readInt();

        //obtenemos el nombre
        for (int i = 0; i < 15; i++) {
          names[i] = raf.readChar();
        }

        //obtenemos el apellido
        for (int i = 0; i < 10; i++) {
          surnames[i] = raf.readChar();
        }

        //Obtenemos el departamento
        dep = raf.readInt();
        //Obtenemos el salario
        salary = raf.readDouble();

        //Creamos el elemento "empleado"
        Element emp = document.createElement("employee");

        //añadimos el nodo al documento
        document.getDocumentElement().appendChild(emp);
        CreateEmployeeNode("id",Integer.toString(id), emp, document);
        CreateEmployeeNode("name", new java.lang.String(names).trim(), emp, document);
        CreateEmployeeNode("surname", new java.lang.String(surnames).trim(), emp, document);
        CreateEmployeeNode("dep",Integer.toString(dep), emp, document);
        CreateEmployeeNode("salary",Double.toString(salary), emp, document);

        pos = pos + 66;

        //Fin del recorrido por el fichero employee.dat
        if(raf.getFilePointer() == raf.length()){
          break;
        }

      }

      //Convertimos la estructura XML generada con DOM en un fichero xml
      Source source = new DOMSource(document);
      Result result = new StreamResult(new File("./out/production/FicherosJava/employees.xml"));
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.transform(source,result);
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    } catch (Exception e){
      raf.close();
    }
  }

  private static void CreateEmployeeNode(java.lang.String tag, java.lang.String value, Element element, Document document) {
    Element newElement = document.createElement(tag);
    Text text = document.createTextNode(value);
    element.appendChild(newElement);
    newElement.appendChild(text);

  }
}
