import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class WritePersonaObjToXml {
  public static void main(String[] args) throws IOException {

    File file = new File("./out/production/FicherosJava/myPeople.dat");

    FileInputStream filein = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(filein);

    PersonSerializable personRead = null;

    //creamos la factoria para construir documentos XML
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    ArrayList<PersonSerializable> people = new ArrayList<PersonSerializable>();

    try {
      while (true) {
        personRead = (PersonSerializable) ois.readObject();
        people.add(personRead);
      }
    } catch (EOFException eof){
      ois.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    try {
      //creamos el constructor
      DocumentBuilder builder = factory.newDocumentBuilder();
      //Obtenemos la implementación del DOM
      DOMImplementation implementation = builder.getDOMImplementation();
      //Creamos el documento vacío
      Document document = implementation.createDocument(null,"People",null);

      //asignamos la versión
      document.setXmlVersion("1.0");

      for (PersonSerializable p: people) {
        //Creamos el elemento "empleado"
        Element person = document.createElement("person");

        document.getDocumentElement().appendChild(person);

        CreatePersonNode("id",Integer.toString(p.getId()),person,document);
        CreatePersonNode("name",p.getName(),person,document);
        CreatePersonNode("age",Integer.toString(p.getAge()),person,document);
      }



      //Convertimos la estructura XML generada con DOM en un fichero xml
      Source source = new DOMSource(document);
      Result result = new StreamResult(new File("./out/production/FicherosJava/myPeople.xml"));
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.transform(source,result);

    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
  }


  private static void CreatePersonNode(java.lang.String tag, java.lang.String value, Element element, Document document) {
    Element newElement = document.createElement(tag);
    Text text = document.createTextNode(value);
    element.appendChild(newElement);
    newElement.appendChild(text);

  }
}