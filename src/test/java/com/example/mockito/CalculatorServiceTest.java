package com.example.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.anyInt;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    private ExternalCalculatorService externalCalculatorService;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    void shouldAddNumbersCorrectly(){

        when(externalCalculatorService.add(2,3)).thenReturn(5);

        int result = calculatorService.addNumbers(2,3);

        assertEquals(5, result);

        verify(externalCalculatorService).add(2,3);
        verifyNoMoreInteractions(externalCalculatorService);
        verify(externalCalculatorService).add(anyInt(), anyInt());

    }
}
