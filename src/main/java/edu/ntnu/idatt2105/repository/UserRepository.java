package edu.ntnu.idatt2105.repository;

import edu.ntnu.idatt2105.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
   User findByUsername(String username);
}