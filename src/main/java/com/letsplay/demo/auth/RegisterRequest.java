package com.letsplay.demo.auth;

import jakarta.validation.constraints.*;

public record RegisterRequest(

    @NotBlank
    String name,

    @Email
    String email,

    @Size(min = 8)
    String password

) {}