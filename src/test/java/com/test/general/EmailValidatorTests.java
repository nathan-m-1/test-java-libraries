package com.test.general;

import net.jqwik.api.*;

public class EmailValidatorTests {

    @Property(tries = 500)
    boolean validEmailsAreRecognized(@ForAll("validEmails") String email){
        System.out.println("Generando email: " + email);
        return EmailValidator.isValidEmail(email);
    }

    @Property(tries = 300)
    boolean randomStringsAreUsuallyInvalid(@ForAll("restrictedStrings") String randomString) {
        // Para cadenas completamente aleatorias, probablemente NO son emails válidos
        System.out.println("Generando randomString: " + randomString);
        return !EmailValidator.isValidEmail(randomString) || randomString.contains("@");
    }

    @Provide
    Arbitrary<String> validEmails(){
        Arbitrary<String> localPart = Arbitraries.strings()
                .withCharRange('a', 'z')
                .ofMinLength(1)
                .ofMaxLength(10);

        Arbitrary<String> domain = Arbitraries.strings()
                .withCharRange('a', 'z')
                .ofMinLength(1).ofMaxLength(10);

        Arbitrary<String> tld = Arbitraries.of("com", "net", "org", "io", "dev");

        return Combinators.combine(localPart, domain, tld)
                .as((local, dom, tldPart) -> local + "@" + dom + "." + tldPart);
    }

    @Provide
    Arbitrary<String> restrictedStrings() {
        // Generar cadenas con solo letras (mayúsculas y minúsculas) y números
        return Arbitraries.strings()
                .withCharRange('a', 'z')  // Letras minúsculas
                .withCharRange('A', 'Z')  // Letras mayúsculas
                .withCharRange('0', '9')  // Números
                .ofMinLength(1)           // Longitud mínima de 1
                .ofMaxLength(10);         // Longitud máxima de 10
    }
}
