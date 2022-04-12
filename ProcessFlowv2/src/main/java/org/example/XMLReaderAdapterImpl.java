package org.example;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLReaderAdapterImpl implements XMLReaderAdapter {

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db= dbf.newDocumentBuilder();
    Document doc = null;

    @Override
    public void setIncludePath(String inputFilePath) {

        try {
            doc = db.parse(new File(inputFilePath));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
    }

    /*@Override
    public String[] readNext() throws IOException {
        return dbf.
    }*/
}
