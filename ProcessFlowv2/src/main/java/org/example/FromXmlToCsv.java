package org.example;

import org.w3c.dom.Document;

public class FromXmlToCsv implements Step{

    private String inputFilePath;
    private final String csvFilePath = "src/points.csv";
    private final XmlReaderAdapter xmlReaderAdapter;
    private final CsvWriterAdapter csvWriterAdapter;

    public FromXmlToCsv(XmlReaderAdapter xmlReaderAdapter, CsvWriterAdapter csvWriterAdapter) {
        this.xmlReaderAdapter = xmlReaderAdapter;
        this.csvWriterAdapter = csvWriterAdapter;
    }

    @Override
    public void setInput(String input) {
        this.inputFilePath = input;
    }

    @Override
    public String getOutput() {
        return csvFilePath;
    }

    @Override
    public void doIt() {
        String outputString = xmlReaderAdapter.readXml(inputFilePath);
        csvWriterAdapter.writeToCsv(outputString, csvFilePath);
    }
}
