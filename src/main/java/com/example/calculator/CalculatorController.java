package com.example.calculator.controller;

import com.example.calculator.model.CalculationLog;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public CalculationLog calculate(@RequestBody String expression) {
        // Log the incoming request
        System.out.println("Received calculation request: " + expression);

        // Perform calculation using the service
        CalculationLog calculationLog = calculatorService.calculate(expression);

        // Log the result
        System.out.println("Calculation result: " + calculationLog.getResult());

        return calculationLog;
    }
}
