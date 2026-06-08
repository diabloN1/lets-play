package com.letsplay.demo.user;

import org.springframework.stereotype.Service;

import com.letsplay.demo.exception.ConflictException;
import com.letsplay.demo.exception.NotFoundException;
import com.letsplay.demo.user.DTO.AddUserRequest;
import com.letsplay.demo.user.DTO.EditUserRequest;
import com.letsplay.demo.user.DTO.UserResponse;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserResponse createUser(AddUserRequest req) {
        if (userRepository.findByEmail(req.email()).isPresent()) {
            throw new ConflictException("Email already exists");
        }

        User user = new User();
        user.setName(req.name());
        user.setEmail(req.email());
        user.setPassword(encoder.encode(req.password()));
        user.setRole(req.role());
        return UserResponse.from(userRepository.save(user));
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return UserResponse.from(user);
    }

    public UserResponse updateUserById(String id, EditUserRequest req) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        
        user.setName(req.name());
        user.setEmail(req.email());
        user.setRole(req.role());
        return UserResponse.from(userRepository.save(user));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}