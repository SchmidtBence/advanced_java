package hu.meiit.haladojava.calculator;

import java.text.DecimalFormat;

public class Service {

    boolean error = false;

    public String[] Separate(String operation){
        String[] separatedValues = new String[0];
        final String SPACE = " ";
        if(operation.contains(SPACE)){
            separatedValues = operation.split(SPACE);
        }else{
            for (int i = 0; i<operation.length(); i++){
                separatedValues = operation.split("");
            }
        }
        return separatedValues;
    }

    public boolean checkStrLenght(String[] strArr){
        if(strArr.length!=3){
            return false;
        }
        return true;
    }

    public float convertToInt(String str){
        float i = 0;
        try {
            i = Integer.parseInt(str);
        }catch(NumberFormatException ex){
            error = true;
        }
        return i;
    }

    public void isDivideWithZero(Operator operator,Operands operands){
        if(operator.getOperator().equals("/") && operands.getSecondOperand()==0.0){
            error=true;
        }
    }

    public String makeOperation(Operator operator, Operands operands){
        DecimalFormat df = new DecimalFormat("0.0");
        Operations operations = new Operations();
        switch (operator.getOperator()){
            case("+"):
                operations.addTwoNumbers(operands.firstOperand,operands.secondOperand);
                break;
            case("-"):
                operations.subtractTwoNumbers(operands.firstOperand,operands.secondOperand);
                break;
            case("*"):
                operations.multiplyTwoNumbers(operands.firstOperand,operands.secondOperand);
                break;
            case("/"):
                operations.divideTwoNumbers(operands.firstOperand,operands.secondOperand);
                break;
        }
        return String.valueOf(df.format(operations.calculationValue));
    }

    public boolean isError() {
        return error;
    }
}
