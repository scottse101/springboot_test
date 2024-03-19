package edu.ntnu.idatt2105.service;

import edu.ntnu.idatt2105.model.CalculationResult;
import edu.ntnu.idatt2105.repository.CalculationLogRepository;
import lombok.extern.slf4j.Slf4j;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculationService {

    private final CalculationLogRepository calculationLogRepository;

    @Autowired
    public CalculationService(CalculationLogRepository calculationLogRepository) {
        this.calculationLogRepository = calculationLogRepository;
    }

    public double calculate(String equation) {
        log.info("Calculating equation: " + equation);
        try {
        Expression expression = new ExpressionBuilder(equation).build();
        double result = expression.evaluate();
        return result;
        } catch (Exception e) {
            log.error("Error calculating equation: " + equation);
            throw new IllegalArgumentException("Invalid equation");
        }
    }

    public CalculationResult saveCalculationResult(CalculationResult calculationResult) {
        return calculationLogRepository.save(calculationResult);
    }

    public Page<CalculationResult> getCalculationResultsByUserId(Long userId, Pageable pageable) {
        return calculationLogRepository.findByUserId(userId, pageable);
    }

    public void deleteCalculationLog(Long id) {
        log.info("Deleting calculation log with id: " + id);
        calculationLogRepository.deleteById(id);
    }

    public void deleteAllCalculationLogs() {
        log.info("Deleting all calculation logs");
        calculationLogRepository.deleteAll();
    }

}
