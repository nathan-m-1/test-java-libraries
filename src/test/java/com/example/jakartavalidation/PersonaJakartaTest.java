package com.example.jakartavalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaJakartaTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        System.out.println("Validator inicializado");
    }

    @AfterAll
    public static void closeValidator() {
        factory.close();
        System.out.println("ValidatorFactory cerrado");
    }

    @Test
    void personaInvalida() {
        PersonaJakarta p = new PersonaJakarta("", 12);

        Set<ConstraintViolation<PersonaJakarta>> violaciones = validator.validate(p);

        if (violaciones.isEmpty()) {
            System.out.println("¡Persona válida!");
        } else {
            violaciones.forEach(v ->
                    System.out.println(v.getPropertyPath() + " -> " + v.getMessage()));
        }

        //assertFalse(validator.validate(p).isEmpty());
    }

    @Test
    void personaValida() {
        PersonaJakarta p = new PersonaJakarta("Ana", 25);
        assertTrue(validator.validate(p).isEmpty());
    }
}
