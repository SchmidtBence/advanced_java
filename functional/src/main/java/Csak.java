import org.example.overrideexample.User;
import org.example.overrideexample.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class Csak {
    public static void main(String[] args){
        Map<String, Integer> nameMap = new HashMap<>();

        Csak csak = new Csak();

        // Function<String, Integer> fv = aa -> aa.length();

        // fv = Csak::length;

        // Integer value = nameMap.computeIfAbsent("John", aa -> aa.length());

        Function<Integer, Integer> anotherFv = a -> 8*a;
        csak.printResult(a -> 8*a);
        csak.printResult(Math::random);
        csak.printResult( () -> Math.random());
        csak.printResult( () -> 4.0);
        csak.dataIn(Csak::dd);
        csak.dataIn( data -> System.out.println(data));

        Predicate<String> notEmpty = s -> ! s.trim().isEmpty();
        Predicate<String> notContaintsY = s -> s.indexOf('Y') == -1;

        List<String> list = new ArrayList<>();

        Predicate<Integer> isGreaterThan0 = number -> number > 0;

        Function<String, Integer> string2int = item -> item.length();

        List<Integer> lengthList = list.stream()
                .map(string2int)
                .filter(isGreaterThan0)
                .collect(Collectors.toList());


        List<Integer> lList = new ArrayList<>();
        for (String item : list) {
            int length = item.length();
            if(length > 0){
                lList.add(length);
            }
        }

        List<User> userList = new ArrayList<>();

        userList.stream().map(user -> new UserDto(user)).collect(Collectors.toList());

        csak.kiirHaOk(notEmpty.and(notContaintsY), "Valami");

    }

    public static void dd(Double d){
        System.out.println(d);
    }

    public static int length(String s){
        return s.length();
    }

    public static int ize(int a){
        return (int) Math.random() * a ;
    }

    private int v(String s){
        return s.indexOf('d');
    }

    //szükséges kimenet és bemenet
    private void printResult(Function<Integer, Integer> fv){
        int result = fv.apply(5);
        System.out.println(result);
    }

    //csak kimenet
    private void printResult(DoubleSupplier fv){
        Double result = fv.getAsDouble();
        System.out.println(result);
    }

    //csak bemenet
    private void dataIn(Consumer<Double> fv){
        fv.accept(8.0);
    }

    //bemenet bármi lehet, kimenet pedig bool
    private void kiirHaOk(Predicate<String> pred, String s){
        if(pred.test(s)){
            System.out.println("-"+s+"-");
        }
    }
}
