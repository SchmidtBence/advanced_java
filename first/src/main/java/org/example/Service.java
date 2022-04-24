package org.example;


public class Service {
    public static String addTwoIntegers(Integer a, Integer b){
        Integer result = a+b;
        return printResult(result.toString());
    }

    public static String extractTwoIntegers(Integer a, Integer b){
        Integer result = a-b;
        return printResult(result.toString());
    }

    public static String multipliTwoIntegers(Integer a, Integer b){
        Integer result = a*b;
        return printResult(result.toString());
    }

    public static String divideTwoIntegers(Integer a, Integer b){
       Float[] floats = convertTwoIntToTwoFloat(a,b);
       Float result = floats[0]/floats[1];
       return printResult(result.toString());
    }

    private static String printResult(String result){
        return "Az eredmény: ".concat(result);
    }

    private static Float[] convertTwoIntToTwoFloat(Integer a, Integer b){
        Float[] floats = new Float[2];
        floats[0] = a.floatValue();
        floats[1] = b.floatValue();
        return floats;
    }
}
