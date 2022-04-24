package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class XmlReaderAdapterImpl implements XmlReaderAdapter {
    @Override
    public String readXml(String input) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new File(input));
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertDocToRightString(doc);
    }

    private String convertDocToRightString(Document doc) {
        StringBuilder sb = new StringBuilder();
        NodeList nodeList = doc.getElementsByTagName("item");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            Element eElement = (Element) node;
            sb.append(eElement.getElementsByTagName("name").item(0).getTextContent());
            sb.append(";");
            sb.append(eElement.getElementsByTagName("point").item(0).getTextContent());
            sb.append("\n");
        }
        return sb.toString();
    }
}