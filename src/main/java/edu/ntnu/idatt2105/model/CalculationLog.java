package edu.ntnu.idatt2105.model;
import jakarta.persistence.*;

@Entity
public class CalculationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expression;
    private double result;

    @ManyToOne
    private User user;

    public CalculationLog() {
    }

    public CalculationLog(String expression, double result, User user) {
        this.expression = expression;
        this.result = result;
        this.user = user;
    }

    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
