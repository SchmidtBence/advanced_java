package hu.meiit.haladojava.calculator;

public class Operations {
    float calculationValue;

    public void addTwoNumbers(float firstNumber, float secondNumber){
        calculationValue = firstNumber + secondNumber;
    }

    public void subtractTwoNumbers(float firstNumber, float secondNumber){
        calculationValue = firstNumber - secondNumber;
    }

    public void multiplyTwoNumbers(float firstNumber, float secondNumber){
        calculationValue = firstNumber * secondNumber;
    }

    public void divideTwoNumbers(float firstNumber, float secondNumber){
        calculationValue = firstNumber / secondNumber;
    }

    public float getCalculationValue(){
        return calculationValue;
    }
}
