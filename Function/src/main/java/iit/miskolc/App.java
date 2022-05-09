package iit.miskolc;

import iit.miskolc.coverter.Converter;
import iit.miskolc.coverter.Runner;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        String[] persons = new String[] {"1;András;11", "2;Béla;3"};
        Runner runner = new Runner();

        runner.addConverter(Converter::fromCsvToInMemoryArray);
        runner.addConverter(Converter::fromInMemoryToXml);
        runner.addConverter(Converter::fromXmlToCsv);

        runner.run(persons);

        System.out.println(Arrays.toString(runner.getResults()));
    }

}
