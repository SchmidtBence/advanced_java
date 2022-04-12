package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CsvReaderAdapter {
    void setIncludePath(String inputFilePath) throws FileNotFoundException;
    String[] readNext() throws IOException;
}
