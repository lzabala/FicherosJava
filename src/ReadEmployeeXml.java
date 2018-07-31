import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class ReadEmployeeXml {
  public static void main(String[] args){

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    try {
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new File("./out/production/FicherosJava/employees.xml"));

      System.out.println("La raiz es: " + document.getDocumentElement().getNodeName());

      NodeList employees = document.getElementsByTagName("employee");

      for (int i = 0; i < employees.getLength(); i++) {
        Node emp = employees.item(i); //obtener un nodo

        if(emp.getNodeType() == Node.ELEMENT_NODE){
          Element elem = (Element) emp;
          System.out.print("Id: " + getInfoNode("id",elem));
          System.out.print(", Name: " + getInfoNode("name",elem));
          System.out.print(", Surname: " + getInfoNode("surname",elem));
          System.out.print(", Dept: " + getInfoNode("dep",elem));
          System.out.println(", Salary: " + getInfoNode("salary",elem));
        }
      }
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
  }

  private static String getInfoNode(String tag, Element elem) {
    NodeList nodo = elem.getElementsByTagName(tag).item(0).getChildNodes();
    Node nodeValue = (Node) nodo.item(0);
    return nodeValue.getNodeValue();
  }
}
