package edu.ntnu.idatt2105.model;

public class CalculationLog {

    private String expression;
    private double result;

    public CalculationLog(String expression, double result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }
}
