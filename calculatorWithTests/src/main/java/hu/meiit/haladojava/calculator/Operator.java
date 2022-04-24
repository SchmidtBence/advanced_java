package hu.meiit.haladojava.calculator;

public class Operator {
    String operator;

    public Operator(String operand) {
        this.operator = operand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperand(String operand) {
        this.operator = operand;
    }
}
