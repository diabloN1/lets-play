package com.letsplay.demo.user;

import org.springframework.web.bind.annotation.*;

import com.letsplay.demo.user.DTO.AddUser;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping({"/users", "/users/"})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody AddUser req) {
        return userService.createUser(req);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}