package org.example;

import org.w3c.dom.Document;


import java.util.List;


public abstract class FlowInterfaceProvider {

    public abstract Document csvToXML();
    public abstract Document readXML();
    public abstract List<String> aggregateToMemory(Document doc, double avg);
    public abstract double aggregateResult(Document doc);
    public abstract void writeToCSV(List<String> list);
    public abstract void writeToXML(List<String> list);


    void runFromCSVToXML(){
        Document doc = csvToXML();
        Double avg = aggregateResult(doc);
        List<String> aggregatedList = aggregateToMemory(doc,avg);
        writeToCSV(aggregatedList);
    }

    void runFromXMLToCSV(){
        Document doc = readXML();
        Double avg = aggregateResult(doc);
        List<String> aggregatedList = aggregateToMemory(doc,avg);
        writeToCSV(aggregatedList);
    }

    void runFromXMLToXML(){
        Document doc = readXML();
        Double avg = aggregateResult(doc);
        List<String> aggregatedList = aggregateToMemory(doc,avg);
        writeToXML(aggregatedList);
    }
}
