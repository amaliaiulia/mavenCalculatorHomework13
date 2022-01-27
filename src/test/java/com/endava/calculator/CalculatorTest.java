package com.endava.calculator;

import com.endava.calculator.Basic.Basic;
import com.endava.calculator.Basic.BasicOperations;
import com.endava.calculator.Expert.Expert;
import com.endava.calculator.Expert.ExpertOperations;
import com.endava.extensions.TestReporterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.launcher.core.LauncherFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith( TestReporterExtension.class )
public class CalculatorTest {

    private BasicOperations basicCalculator;
    private ExpertOperations expertCalculator;

    @BeforeAll
    public static void setUpAllTests() {
        //LauncherFactory.create().registerLauncherDiscoveryListeners(myCustomListener);
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        basicCalculator = new Basic();
        expertCalculator = new Expert();
        System.out.println("\nBefore Each");
    }

    @AfterEach
    public void tearDownAfterEach() {
        System.out.println("After Each\n");
    }

    //testcases for add method

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest  //data driven testing (DDT)
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b, long expected) {

        //GIVEN
        //BasicOperations basicCalculator = new Basic(); -> am mutat instantierea in beforeEach



        //WHEN - actiunea pe care o testez; trb sa fie una singura intr-un testcase
        long result = basicCalculator.add(a, b);

        //THEN
        assertThat(result, is(expected));


    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 2));
        argumentsList.add(Arguments.of(2, 0, 2));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(-2, -4);

        //THEN
        assertEquals(-6, result);
        assertTrue(result == -6);

    }

    //BUG found: JIRA-78634
    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    @DisplayName("Test that adds a big number as: MAX INT")
    public void shouldAddBigNumbers() {

        assertThrows( AssertionError.class, () -> {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(Integer.MAX_VALUE, 1);

        //THEN
        assertThat(result, is(Integer.MAX_VALUE + 1L));
        assertThat(result, lessThan(0L));
        assertThat(result, notNullValue());
    });
    }

    @ParameterizedTest
    @CsvSource( {"1, 2, 3, 6", "2, 4, 5, 11"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(Integer a1, Integer a2, Integer a3, long expected) {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(a1, a2, a3);

        //THEN
        assertThat(result, is(expected));
    }

    @Test
    public void shouldAddNoOperands() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add();

        //THEN
        assertThat(result,is(0L) );
    }

    @Test
    public void shouldAddOneOperand() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(167);

        //THEN
        assertThat(result, is(167L));
    }

    //testcases for multiply method

    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldMultiplyNumbersGivenOperand0(int a, int b) {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(a, b);

        //THEN
        assertThat(result, is(0L) );

    }

    @ParameterizedTest
    @MethodSource("numberProvider1")
    public void shouldMultiplyNumbersGivenOperand1(int a, int b, long expected) {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(a, b);

        //THEN
        assertThat(result, is(expected));

    }


    public static List<Arguments> numberProvider1() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(1, 2, 2));
        argumentsList.add(Arguments.of(2, 1, 2));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldMultiplyNegativeNumbers() {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(-2, -4);

        //THEN
        assertThat(result, is(8L));

    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldMultiplyBigNumbers() {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(Integer.MAX_VALUE, 1);

        //THEN
        assertThat(result, is(Integer.MAX_VALUE+0L));
    }

    @ParameterizedTest
    @CsvSource( {"1, 2, 3, 6", "2, 4, 5, 40"})
    @CsvFileSource(resources = "numberSource1.csv")
    public void shouldMultiplyMoreThan2Operands(Integer a1, Integer a2, Integer a3, long expected) {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(a1, a2, a3);

        //THEN
        assertThat(result, is(expected));
    }

    @Test
    public void shouldMultiplyNoOperands() {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply();

        //THEN
        assertThat(result, is(1L));
    }

    @Test
    public void shouldMultiplyOneOperand() {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(167);

        //THEN
        assertThat(result, is(167L));
    }

    //testcases for pow method

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProviderGivenOperand0Pow")
    public void shouldPowNumbersGivenOperand0(int a, int b, double expected) {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(a, b);

        //THEN
        assertThat(result, is(expected));
    }

    public static List<Arguments> numberProviderGivenOperand0Pow() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 0));
        argumentsList.add(Arguments.of(2, 0, 1));

        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("numberProviderGivenOperand1Pow")
    public void shouldPowNumbersGivenOperand1(int a, int b, double expected) {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(a, b);

        //THEN
        assertThat(result,is(expected));

    }

    public static List<Arguments> numberProviderGivenOperand1Pow() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(1, 2, 1));
        argumentsList.add(Arguments.of(2, 1, 2));

        return argumentsList;
    }


    @Tag("smoke")
    @Test
    public void shouldPowNegativeNumbers() {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(-2, -4);

        //THEN
        assertThat(result, is(0.0625));

    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldPowBigNumbers() {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(Integer.MAX_VALUE, 1);

        //THEN
        assertThat(result, is(2.147483647E9));
    }

    @ParameterizedTest
    @MethodSource("exponentOrBase")
    public void shouldPowExponentOrBaseNegative(int a, int b, double expected) {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(a, b);

        //THEN
        assertThat(result, is(expected));
    }

    public static List<Arguments> exponentOrBase() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(-1, 2, 1));
        argumentsList.add(Arguments.of(2, -1, 0.5));

        return argumentsList;
    }


    //testcases for fact method

    @Tags({@Tag("smoke"), @Tag("ui")})
    @Test
    public void shouldFactNumbersGivenOperand0() {

        //GIVEN

        //WHEN - actiunea pe care o testez; trb sa fie una singura intr-un testcase
        long result = expertCalculator.fact(0);

        //THEN
        assertThat(result,is(1L));
    }

    @Test
    public void shouldFactNumbersGivenOperand1() {

        //GIVEN

        //WHEN - actiunea pe care o testez; trb sa fie una singura intr-un testcase
        long result = expertCalculator.fact(1);

        //THEN
        assertThat(result, is(1L));
    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldFactBigNumbers() {

        //GIVEN

        //WHEN
        long result = expertCalculator.fact(30);

        //THEN
        assertThat(result, is(-8764578968847253504L));
    }



}
