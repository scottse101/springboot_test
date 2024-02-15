package edu.ntnu.idatt2105.service;

import org.springframework.stereotype.Service;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Service
public class CalculatorService {

    public double calculate (String expression) {
        Expression expressionResult = new ExpressionBuilder(expression).build();
        double result = expressionResult.evaluate();
        return result;
    }
}
