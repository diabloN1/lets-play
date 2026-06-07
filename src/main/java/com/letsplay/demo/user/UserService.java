package com.letsplay.demo.user;

import org.springframework.stereotype.Service;

import com.letsplay.demo.exception.ConflictException;
import com.letsplay.demo.exception.NotFoundException;
import com.letsplay.demo.user.DTO.AddUser;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public User createUser(AddUser req) {
        if (userRepository.findByEmail(req.email()).isPresent()) {
            throw new ConflictException("Email already exists");
        }

        User user = new User();
        user.setName(req.name());
        user.setEmail(req.email());
        user.setPassword(encoder.encode(req.password()));
        user.setRole(req.role());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}