package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FronCSVtoXML implements Step {

    private final XmlMapper xmlMapper;
    private final CsvReaderAdapter csvReaderAdapter;
    private final String xmlFilePath="src/points.xml";
    private String inputFilePath;

    public FronCSVtoXML(XmlMapper xmlMapper, CsvReaderAdapter csvReaderAdapter) {
        this.xmlMapper = xmlMapper;
        this.csvReaderAdapter = csvReaderAdapter;
    }

    /*public FronXMLtoArray(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;

    }*/

    @Override
    public void setInput(String input) throws FileNotFoundException {
        csvReaderAdapter.setIncludePath(inputFilePath);
        this.inputFilePath=input;
    }

    @Override
    public String getOutput() {
        return xmlFilePath;
    }

    @Override
    public void doIt() {
        try {
            List<Result> allResult=getAllResult();
            xmlMapper.writeValue(new File("simple_bean.xml"), allResult);
        } catch (IOException e) {
            throw new RuntimeException("Error during serializing object",e);
        }
    }

    private List<Result> getAllResult() throws IOException {
        List<Result> outputresults=new ArrayList<>();
            String[] values;
            while ((values = csvReaderAdapter.readNext()) != null) {
                outputresults.add(new Result(values[0],Double.parseDouble(values[1])));
            }
        return outputresults;
    }
}
