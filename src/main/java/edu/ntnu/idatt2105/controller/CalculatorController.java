package edu.ntnu.idatt2105.controller;

import edu.ntnu.idatt2105.model.CalculationLog;
import edu.ntnu.idatt2105.service.CalculatorService;
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
        System.out.println("Received calculation request: " + expression);

        CalculationLog calculationLog = calculatorService.calculate(expression);

        System.out.println("Calculation result: " + calculationLog.getResult());

        return calculationLog;
    }

    @PostMapping("/calculateJSON")
    public CalculationLog calculateJSON(@RequestBody CalculationLog calculationLog) {
        System.out.println("Received calculation request: " + calculationLog.getExpression());

        CalculationLog result = calculatorService.calculate(calculationLog.getExpression());

        System.out.println("Calculation result: " + result.getResult());

        return result;
    }
}
