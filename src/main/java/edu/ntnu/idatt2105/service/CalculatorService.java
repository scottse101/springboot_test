package edu.ntnu.idatt2105.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ntnu.idatt2105.model.CalculationLog;
import edu.ntnu.idatt2105.model.User;
import edu.ntnu.idatt2105.repository.CalculationLogRepository;
import edu.ntnu.idatt2105.repository.UserRepository;

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
        // Initialize a ScriptEngine instance
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        double result = 0.0;

        try {
            // Evaluate the expression using the ScriptEngine
            Object evalResult = engine.eval(expression);

            // Convert the result to a double
            result = Double.parseDouble(evalResult.toString());
        } catch (ScriptException e) {
            // Handle script evaluation errors
            e.printStackTrace();
        }

        // Get the user from the repository
        User user = userRepository.findByUsername(username);

        // Save calculation log in the database
        CalculationLog calculationLog = new CalculationLog(expression, result, user);
        calculationLog.setUser(user);
        calculationLogRepository.save(calculationLog);

        return result;
    }
}
