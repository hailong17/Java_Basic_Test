package Exercise1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
    public static void parseXML(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder        = factory.newDocumentBuilder();
            Document document              = builder.parse(xmlFilePath);

			document.normalizeDocument();

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			NodeList nodeList = document.getElementsByTagName("student");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("\nNode Name :" + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element tElement = (Element)node;
					System.out.println("Name: " + tElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Age: " + tElement.getElementsByTagName("age").item(0).getTextContent());
					System.out.println("Subject: " + tElement.getElementsByTagName("subject").item(0).getTextContent());
					System.out.println("Gender: " + tElement.getElementsByTagName("gender").item(0).getTextContent());
				}
			}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
        String xmlFilePath = "C:/Users/LongNH63/OneDrive - FPT Corporation/Desktop/Java_basic/Assignment8/Exercise1/student.xml";
		parseXML(xmlFilePath);
	}
}
