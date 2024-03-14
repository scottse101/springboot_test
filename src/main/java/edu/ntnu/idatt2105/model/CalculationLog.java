package edu.ntnu.idatt2105.model;
import jakarta.persistence.*;

public class CalculationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expression;
    private double result;

    @ManyToOne
    private User user;

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

    public void setUser(User user) {
        this.user = user;
    }

}
