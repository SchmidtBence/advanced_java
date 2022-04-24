package org.example;

public class XmlToMemoryArray implements Step{

    private String inputFilePath;
    private String result;
    private final XmlReaderAdapter xmlReaderAdapter;

    public XmlToMemoryArray(XmlReaderAdapter xmlReaderAdapter) {
        this.xmlReaderAdapter = xmlReaderAdapter;
    }

    @Override
    public void setInput(String input) {
        this.inputFilePath = input;
    }

    @Override
    public String getOutput() {
        return result;
    }

    @Override
    public void doIt() {
        result = xmlReaderAdapter.readXml(inputFilePath);
    }
}
