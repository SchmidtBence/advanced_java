package org.example;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaderAdapterImpl implements CsvReaderAdapter {

    private CSVReader reader;

    @Override
    public void setIncludePath(String inputFilePath) throws FileNotFoundException {
        reader=new CSVReader(new FileReader(inputFilePath));
    }

    @Override
    public String[] readNext() throws IOException {
        return reader.readNext();
    }
}
