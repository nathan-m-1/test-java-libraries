package com.example.lombokvalidation;

import org.junit.jupiter.api.Test;

public class TestLombokValidation {

    @Test
    public void testLombokValidation(){
        Persona persona = new Persona("null");
        persona.saludar(null
        );
    }
}
