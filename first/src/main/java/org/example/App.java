package org.example;

import java.util.Scanner;

public class App
{

    private static String readValue(){
        Scanner input = new Scanner(System.in);
        System.out.println("Adj meg egy egész számot");
        String value = input.next();
        return value;
    }

    private static Integer checkInteger(String value){
        Integer valueInInteger=null;
        try {
            valueInInteger = Integer.parseInt(value);
        } catch (NumberFormatException ex){
            System.err.println("Nem egész számértéket adtál meg! Így hibás lehet a végeredmény!");
        }
        return valueInInteger;
    }

    private static String readOperator(){
        Scanner input = new Scanner(System.in);
        System.out.println("Adj meg artimetikai műveletet (+,-,*,/)");
        String operand = input.next();
        return operand;
    }

    private static String checkOperator(String operator){
        if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")){

        } else{
            System.err.println("Hibás operátort adtál meg, így hibás lehet a végeredmény!");
        }
        return operator;
    }

    private static void calculateResult(Integer a, Integer b, String operator){
        switch (operator){
            case "+":
                System.out.println(new Service().addTwoIntegers(a,b));
                break;
            case "-":
                System.out.println(new Service().extractTwoIntegers(a,b));
                break;
            case "*":
                System.out.println(new Service().multipliTwoIntegers(a,b));
                break;
            case "/":
                System.out.println(new Service().divideTwoIntegers(a,b));
        }
    }


    public static void main(String[] args ) {

        Operands operands = new Operands();
        Operator operator = new Operator();

        operands.setA(checkInteger(readValue()));
        operator.setOperator(checkOperator(readOperator()));
        operands.setB(checkInteger(readValue()));

        Integer a = operands.getA();
        Integer b= operands.getB();

        calculateResult(a,b,operator.getOperator());
    }
}
