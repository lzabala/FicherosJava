import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MyXmlHandler extends DefaultHandler {

  //constructor
  public MyXmlHandler(){
    super();
  }

  @Override
  public void startDocument(){
    System.out.println("Comienzo documento XML");
  }

  @Override
  public void endDocument(){
    System.out.println("Fin documento XML");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes){
    System.out.print("  " + localName + ":");
    if(localName == "employee"){
      System.out.println("");
    }

  }

  @Override
  public void characters(char[] ch, int start, int length){
    String text = new String(ch,start,length);
    System.out.println(text);
  }

}
