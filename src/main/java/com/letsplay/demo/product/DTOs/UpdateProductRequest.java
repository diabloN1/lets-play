package com.letsplay.demo.product.DTOs;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateProductRequest(

    @NotBlank
    @Size(max = 100)
    String name,

    @NotBlank
    @Size(max = 1000)
    String description,

    @DecimalMin(value = "0.0", inclusive = false)
    double price

) {}