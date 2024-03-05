package edu.ntnu.idatt2105.controller;

import edu.ntnu.idatt2105.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody String equation, @RequestParam String username) {
        System.out.println(equation);
        double result = calculatorService.calculate(equation, username);
        return ResponseEntity.ok(Double.toString(result));
    }
}
