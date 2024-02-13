package edu.ntnu.idatt2105.service;

import edu.ntnu.idatt2105.model.CalculationLog;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculationLog calculate(String expression) {
        try {
            String[] parts = expression.split(" ");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid input. Expected format: operand1 operator operand2");
            }

            double operand1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double operand2 = Double.parseDouble(parts[2]);

            double result;

            switch (operator) {
                case "+":
                    result = add(operand1, operand2);
                    break;
                case "-":
                    result = subtract(operand1, operand2);
                    break;
                case "*":
                    result = multiply(operand1, operand2);
                    break;
                case "/":
                    result = divide(operand1, operand2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator. Supported operators: +, -, *, /");
            }

            System.out.println("Performed calculation: " + expression + " = " + result);

            return new CalculationLog(expression, result);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Operand must be a valid number.", e);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
    }

    private double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private double divide(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return operand1 / operand2;
    }
}
