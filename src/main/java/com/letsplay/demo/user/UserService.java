package com.letsplay.demo.user;

import org.springframework.stereotype.Service;

import com.letsplay.demo.auth.RegisterRequest;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public User createUser(RegisterRequest req) {
        if (userRepository.findByEmail(req.email()).isPresent()) {
            // throw new Exception("Email already exists"); // Bad request
        }

        User user = new User();
        user.setName(req.name());
        user.setEmail(req.email());
        user.setPassword(encoder.encode(req.password()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}