package edu.ntnu.idatt2105.repository;

import edu.ntnu.idatt2105.model.CalculationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationLogRepository extends JpaRepository<CalculationLog, Long> {
    // Add custom query methods if needed
}