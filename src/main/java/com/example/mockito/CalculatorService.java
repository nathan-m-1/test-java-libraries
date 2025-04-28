package com.example.mockito;

public class CalculatorService {

    private final ExternalCalculatorService externalService;

    public CalculatorService(ExternalCalculatorService externalService) {
        this.externalService = externalService;
    }

    public int addNumbers(int a, int b) {
        return externalService.add(a, b);
    }
}
