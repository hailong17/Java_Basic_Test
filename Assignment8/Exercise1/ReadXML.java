package Exercise1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ReadXML {
    public static void parseXML(String xmlFilePath) {
		String name, age, subject, gender;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder        = factory.newDocumentBuilder();
            Document document              = builder.parse(xmlFilePath);

			document.normalizeDocument();

			NodeList nodeList = document.getElementsByTagName("student");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element node = (Element) nodeList.item(i);
				System.out.println("\nNode Name :" + node.getNodeName());

				name    = extractNode(node, "name");
				age     = extractNode(node, "age");
				subject = extractNode(node, "subject");
				gender  = extractNode(node, "gender");
				System.out.println("Name: " + name + "\n" + "Age: " + age + "\n" + "Subject: " + subject + "\n" + "gender: " + gender);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String extractNode(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Element nodeElement = (Element) nodeList.item(0);
            return nodeElement.getTextContent();
        }
        return "";
    }

	public static void main(String[] args) {
		String userDirectory = System.getProperty("user.dir");
		String xmlFilePath   = userDirectory.replace("\\", "/") + "/Assignment8/Exercise1/student.xml";
		parseXML(xmlFilePath);
	}
}
