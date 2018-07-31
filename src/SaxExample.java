import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Utilizando SAX (API Simple para XML) crea un parseador para el fichero employee.xml
 * */
public class SaxExample {
  public static void main(String[] args) throws IOException, SAXException {
    XMLReader procesadorXML = XMLReaderFactory.createXMLReader();

    MyXmlHandler xmlHandler = new MyXmlHandler();
    procesadorXML.setContentHandler(xmlHandler);

    InputSource fileXML = new InputSource("./out/production/FicherosJava/employees.xml");
    procesadorXML.parse(fileXML);
  }
}
