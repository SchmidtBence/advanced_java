package org.example;

import com.opencsv.CSVReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteImplementation extends FlowInterfaceProvider{

    private final String csvFilePath = "src/points.csv";
    private final String xmlFilePath = "src/points.xml";

    @Override
    public Document csvToXML() {
        String[] names = getNamesFromCsv();
        String[] points = getPointsFromCsv();
        String xmlStr = "<pairs>";
        for (int i=0;i<names.length;i++){
            xmlStr = xmlStr+
                    "<person>"+
                    "<name>"+names[i]+"</name>"+
                    "<point>"+points[i]+"</point>"+
                    "</person>";
        }
        xmlStr = xmlStr + "</pairs>";

        Document doc = convertStringToXMLDocument( xmlStr );
        return doc;

    }

    @Override
    public Document readXML() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new File(xmlFilePath));
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    @Override
    public List<String> aggregateToMemory(Document doc, double avg) {
        setAggregatedValue(doc, avg);
        String[] names = getNamesFromXML(doc);
        String[] points = getPointsFromXML(doc);
        List<String> list = new ArrayList<>();
        for (int i=0;i<names.length;i++){
            list.add(names[i]+";"+points[i]);
        }
        return list;
    }

    @Override
    public double aggregateResult(Document doc) {
        return calculateAvergage(doc);
    }

    @Override
    public void writeToCSV(List<String> aggregatedList) {
        try {
            PrintWriter pw = new PrintWriter(new File(csvFilePath));

            for (int i=0;i<aggregatedList.size();i++){
                String[] data = splitByComma(aggregatedList.get(i));
                StringBuilder builder = new StringBuilder();
                builder.append(data[0]+";");
                builder.append(data[1]);
                builder.append('\n');
                pw.write(builder.toString());
            }
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToXML(List<String> list){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new File(xmlFilePath));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("person");
            for (int i=0;i<nodeList.getLength();i++){
                String[] points = splitByComma(list.get(i));

                Node node = nodeList.item(i);
                Element element = (Element) node;
                element.getElementsByTagName("point").item(0).setTextContent(points[1]);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer= transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result=new StreamResult(new File(xmlFilePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] getNamesFromXML(Document doc){
        NodeList nodeList = doc.getElementsByTagName("person");
        String[] names = new String[nodeList.getLength()];
        for (int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            Element element = (Element) node;
            names[i] = element.getElementsByTagName("name").item(0).getTextContent();
        }
        return names;
    }

    private static String[] getPointsFromXML(Document doc){
        NodeList nodeList = doc.getElementsByTagName("person");
        String[] points = new String[nodeList.getLength()];
        for (int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            Element element = (Element) node;
            points[i] = element.getElementsByTagName("point").item(0).getTextContent();
        }
        return points;
    }

    private static void setAggregatedValue(Document doc, double avg){
        NodeList nodeList = doc.getElementsByTagName("person");
        for (int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            Element element = (Element) node;
            element.getElementsByTagName("point").item(0).setTextContent(String.valueOf(avg));
        }
    }

    private static Double calculateAvergage(Document doc){
        NodeList nodeList = doc.getElementsByTagName("person");
        double sum=0;
        for (int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            Element element = (Element) node;
            sum = sum+Double.parseDouble(element.getElementsByTagName("point").item(0).getTextContent());
        }
        return sum/Double.parseDouble(String.valueOf(nodeList.getLength()));
    }

    private static Document convertStringToXMLDocument(String xmlString)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try
        {
            builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private String[] getNamesFromCsv(){
        List<List<String>> pointsList = readCSV(csvFilePath);
        String[][] pointsArr = convertList2DTo2DArr(pointsList);
        String[] names = new String[pointsArr.length];
        for (int i=0;i<pointsArr.length;i++){
            names[i] = splitByComma(pointsArr[i][0])[0];
        }
        return names;
    }

    private String[] getPointsFromCsv(){
        List<List<String>> pointsList = readCSV(csvFilePath);
        String[][] pointsArr = convertList2DTo2DArr(pointsList);
        String[] points = new String[pointsArr.length];
        for (int i=0;i<pointsArr.length;i++){
            points[i] = splitByComma(pointsArr[i][0])[1];
        }
        return points;
    }

    private List<List<String>> readCSV(String fileName) {
        List<List<String>> points = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                points.add(Arrays.asList(values));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return points;
    }

    private String[][] convertList2DTo2DArr(List<List<String>> list){
        String[][] arr = list.stream()
                .map(l -> l.stream().toArray(String[]::new))
                .toArray(String[][]::new);
        return arr;
    }

    private String[] splitByComma(String pair){
        String[] separated = pair.split(";");
        return separated;
    }
}