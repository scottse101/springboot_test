package edu.ntnu.idatt2105.service;

import edu.ntnu.idatt2105.model.User;
import edu.ntnu.idatt2105.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public Long getUserIdByUsername(String username) {
        return userRepository.findByUsername(username).getId();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public String getPasswordByUsername(String username) {
        return userRepository.findByUsername(username).getPassword();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public boolean validateUser(User user) {
        user = userRepository.findByUsername(user.getUsername());
        return user != null && user.getPassword().equals(user.getPassword());
    }
}
