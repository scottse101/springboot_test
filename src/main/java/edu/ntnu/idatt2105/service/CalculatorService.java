package edu.ntnu.idatt2105.service;

import edu.ntnu.idatt2105.model.CalculationLog;
import edu.ntnu.idatt2105.model.User;
import edu.ntnu.idatt2105.repository.CalculationLogRepository;
import edu.ntnu.idatt2105.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final CalculationLogRepository calculationLogRepository;
    private final UserRepository userRepository;

    @Autowired
    public CalculatorService(CalculationLogRepository calculationLogRepository, UserRepository userRepository) {
        this.calculationLogRepository = calculationLogRepository;
        this.userRepository = userRepository;
    }

    public double calculate(String expression, String username) {
        // Perform calculation
        double result = // Your calculation logic

                // Save calculation log in the database
                User user = userRepository.findByUsername(username);
        CalculationLog calculationLog = new CalculationLog(expression, result, user);
        calculationLogRepository.save(calculationLog);

        return result;
    }
}
