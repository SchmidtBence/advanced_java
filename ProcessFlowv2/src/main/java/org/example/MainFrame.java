package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class MainFrame
{
    public static void main( String[] args ) {
        Step step=new FronCSVtoXML(new XmlMapper(),new CsvReaderAdapterImpl());
        step.doIt();
    }
}
