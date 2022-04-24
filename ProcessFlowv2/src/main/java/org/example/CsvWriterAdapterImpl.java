package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWriterAdapterImpl implements CsvWriterAdapter {
    @Override
    public void writeToCsv(String outputString, String csvFilePath) {
        try {
            PrintWriter writer = new PrintWriter(csvFilePath);
            writer.write(outputString);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
