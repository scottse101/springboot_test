package edu.ntnu.idatt2105.controller;

import edu.ntnu.idatt2105.service.CalculatorService;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<String> calculate(@RequestBody String equation) {
        System.out.println(equation);
        Expression expression = new ExpressionBuilder(equation).build();
        double result = expression.evaluate();
        return ResponseEntity.ok(Double.toString(result));
    }
}
