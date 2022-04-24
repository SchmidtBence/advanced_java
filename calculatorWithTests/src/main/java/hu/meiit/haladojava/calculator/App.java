package hu.meiit.haladojava.calculator;


import java.text.DecimalFormat;
import java.util.Scanner;
import hu.meiit.haladojava.calculator.Service;

public class App
{

    public static String getOperation(){
        Scanner input = new Scanner(System.in);
        String operation = input.nextLine();
        return operation;
    }

    public static void error(){
        System.out.println("-");
    }

    public static void main( String[] args ){
            Service service = new Service();

            String operation=getOperation();

            String[] separatedOperation = service.Separate(operation);

            if(service.checkStrLenght(separatedOperation)){
                float a = service.convertToInt(separatedOperation[0]);
                float b = service.convertToInt(separatedOperation[2]);

                Operator operator = new Operator(separatedOperation[1]);
                Operands operands = new Operands(a,b);

                service.isDivideWithZero(operator,operands);

                if(!service.isError()){
                    System.out.println(service.makeOperation(operator,operands));
                }else{
                    error();
                }
            }else{
                error();
            }






    }
}
