package com.endava.calculator;

import com.endava.calculator.Basic.Basic;
import com.endava.calculator.Basic.BasicOperations;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTestAssertJ {
    private BasicOperations basicCalculator = new Basic();

    @Test
    public void shouldAddOneOperand() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(167);

        //THEN
        assertThat(result).isBetween(100L, 200L)
                .isGreaterThan(150L)
                .isEqualTo(168L)
                .isNotNegative()
                .isNull();

    }
}
