package com.letsplay.demo.user.DTO;
import com.letsplay.demo.user.Role;
import com.letsplay.demo.user.User;

public record UserResponse(
    String id,
    String name,
    String email,
    Role role
) {


    public static UserResponse from(User user) {
        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole()
        );
    }
}