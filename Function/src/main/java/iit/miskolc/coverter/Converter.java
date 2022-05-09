package iit.miskolc.coverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import iit.miskolc.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static Object[] fromCsvToInMemoryArray(Object[] input) {
        List<Object> result = new ArrayList();

        try {
            for (Object inputElement : input) {
                String[] splittedCsvElement = inputElement.toString().split(";");
                if (splittedCsvElement.length <= 1) {
                    throw new Exception("Error during csv reading");
                }
                    Person person = new Person(Integer.parseInt(splittedCsvElement[0]), splittedCsvElement[1], Integer.parseInt(splittedCsvElement[2]));
                    result.add(person);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result.toArray();
    }

    public static Object[] fromInMemoryToXml(Object[] input) {
        ObjectMapper mapper = new XmlMapper();
        List<Object> result = new ArrayList();

        try {
            for (Object element : input){
                Person person = (Person) element;
                result.add(mapper.writeValueAsString(person));
            }

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return result.toArray();
    }


    public static Object[] fromXmlToCsv(Object[] input) {
        ObjectMapper mapper = new XmlMapper();
        List<Object> result = new ArrayList();
        ArrayList<Person> people =  new ArrayList<>();
        try {
            for (Object inputElement : input) {
                System.out.println(Arrays.toString(input));
                try {
                    people.add(mapper.readValue(inputElement.toString(), Person.class));
                    result = people.stream().map((person) -> String.format("%s:%s:%s;", person.getId(), person.getName(), person.getAge())).collect(Collectors.toList());
                } catch (JsonProcessingException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result.toArray();
    }
}
