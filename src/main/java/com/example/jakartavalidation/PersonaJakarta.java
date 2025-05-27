package com.example.jakartavalidation;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaJakarta {

    @NotBlank           // No nulo y no vacío
    private String nombre;

    @NotNull
    @Min(18)            // Debe ser ≥ 18
    private Integer edad;
}
