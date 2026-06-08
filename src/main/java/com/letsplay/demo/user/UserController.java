package com.letsplay.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.letsplay.demo.user.DTO.CreateRequest;
import com.letsplay.demo.user.DTO.EditRequest;
import com.letsplay.demo.user.DTO.UpdateRequest;
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
    public UserResponse createUser(@Valid @RequestBody CreateRequest req) {
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
    public UserResponse updateUser(@PathVariable String id, @RequestBody UpdateRequest req) {
        return userService.updateUserById(id, req);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editUser(@PathVariable String id, @RequestBody EditRequest req) {
        userService.editUserById(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}