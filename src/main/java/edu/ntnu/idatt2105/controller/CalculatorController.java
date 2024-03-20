package edu.ntnu.idatt2105.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ntnu.idatt2105.model.CalculationLog;
import edu.ntnu.idatt2105.model.CalculationResult;
import edu.ntnu.idatt2105.model.User;
import edu.ntnu.idatt2105.service.CalculationService;
import edu.ntnu.idatt2105.service.UserService;

@RestController
public class CalculatorController {

    private final CalculationService calculationService;
    private final UserService userService;

    @Autowired
    public CalculatorController(CalculationService calculationService, UserService userService) {
        this.calculationService = calculationService;
        this.userService = userService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestBody CalculationLog calculationLog) {
        try {
            String equation = calculationLog.getEquation();
            User user = calculationLog.getUser();

            double result = calculationService.calculate(equation);
            CalculationResult calculationResult = new CalculationResult();
            calculationResult.setExpression(equation);
            calculationResult.setAnswer(result);
            calculationResult.setUser(user);
            calculationService.saveCalculationResult(calculationResult);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/calculation-results/{userId}")
    public ResponseEntity<Page<CalculationResult>> getCalculationResultsByUserId(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,desc") String sort) {
        try {
            String[] sortArray = sort.split(",");
            String sortBy = sortArray[0];
            String sortOrder = sortArray.length > 1 ? sortArray[1] : "desc"; // Assuming ascending order if not specified
            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
            Page<CalculationResult> calculationResultsPage = calculationService.getCalculationResultsByUserId(userId, pageable);
            return ResponseEntity.ok(calculationResultsPage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
