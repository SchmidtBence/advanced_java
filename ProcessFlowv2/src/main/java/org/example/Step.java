package org.example;

import java.io.FileNotFoundException;

public interface Step {
    void setInput(String input) throws FileNotFoundException;
    String getOutput();
    void doIt();
}
