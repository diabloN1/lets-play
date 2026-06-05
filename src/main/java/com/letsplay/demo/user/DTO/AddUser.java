package com.letsplay.demo.user.DTO;

import com.letsplay.demo.user.Role;

import jakarta.validation.constraints.*;

public record AddUser(

    @NotBlank
    String name,

    @Email
    @NotBlank
    String email,

    @NotNull
    Role role,


    @Size(min = 8)
    @NotBlank
    String password

) {}