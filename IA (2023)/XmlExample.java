import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlExample {
  public static void main(String[] args) {
    try {
      // create a new DocumentBuilderFactory
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      // create a new DocumentBuilder
      DocumentBuilder builder = factory.newDocumentBuilder();

      // create a new Document
      Document document = builder.newDocument();

      // create the root element
      Element root = document.createElement("students");

      // create a new element
      Element student = document.createElement("student");

      // set attribute to student
      student.setAttribute("id", "1");

      // create name element
      Element name = document.createElement("name");
      name.appendChild(document.createTextNode("John Doe"));

      // create age element
      Element age = document.createElement("age");
      age.appendChild(document.createTextNode("22"));

      // add name and age elements to student
      student.appendChild(name);
      student.appendChild(age);

      // add student element to root
      root.appendChild(student);

      // add root element to document
      document.appendChild(root);

      // create a Transformer object
      Transformer transformer = TransformerFactory.newInstance().newTransformer();

      // transform the Document into a StreamResult
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(System.out);
      transformer.transform(source, result);

    } catch (ParserConfigurationException | TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    }
  }
}
