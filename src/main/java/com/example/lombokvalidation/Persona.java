package com.example.lombokvalidation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Persona {

    @NonNull
    @Getter
    @Setter
    private String nombre;

    public void saludar(@NonNull String mensaje) {
        System.out.println(mensaje + ", soy " + nombre);
    }
}
