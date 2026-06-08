package com.letsplay.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.letsplay.demo.user.DTO.AddUserRequest;
import com.letsplay.demo.user.DTO.EditUserRequest;
import com.letsplay.demo.user.DTO.UserResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody AddUserRequest req) {
        return userService.createUser(req);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("{id}")
    public UserResponse updateUser(@PathVariable String id, @RequestBody EditUserRequest req) {
        return userService.updateUserById(id, req);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}