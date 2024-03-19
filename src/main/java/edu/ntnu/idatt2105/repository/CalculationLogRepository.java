package edu.ntnu.idatt2105.repository;

import edu.ntnu.idatt2105.model.CalculationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CalculationLogRepository extends JpaRepository<CalculationResult, Long> {
    Page<CalculationResult> findByUserId(Long userId, Pageable pageable);
}