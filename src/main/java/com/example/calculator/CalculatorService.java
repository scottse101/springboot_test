package com.example.calculator.service;

import com.example.calculator.model.CalculationLog;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculationLog calculate(String expression) {
        // Perform calculations using a math library or custom logic
        // You can use mathjs or any other library that suits your needs
        // Ensure to handle exceptions for invalid input

        // For simplicity, let's assume a placeholder calculation for now
        double result = 0; // Placeholder, replace with actual calculation logic

        // Log the calculation
        System.out.println("Performed calculation: " + expression + " = " + result);

        // Create a CalculationLog object to store the result and expression
        return new CalculationLog(expression, result);
    }
}
