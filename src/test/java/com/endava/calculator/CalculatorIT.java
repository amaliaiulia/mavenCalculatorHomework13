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

import java.util.ArrayList;
import java.util.List;

@ExtendWith( TestReporterExtension.class )
public class CalculatorIT {

    private BasicOperations basicCalculator;
    private ExpertOperations expertCalculator;

    @BeforeAll
    public static void setUpAllTests() {
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
    public void shouldAddNumbersGivenOperand0(int a, int b) {

        //GIVEN
        //BasicOperations basicCalculator = new Basic(); -> am mutat instantierea in beforeEach

        //WHEN - actiunea pe care o testez; trb sa fie una singura intr-un testcase
        long result = basicCalculator.add(a, b);

        //THEN
        System.out.println(result);
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(-2, -4);

        //THEN
        System.out.println(result);

    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldAddBigNumbers() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(Integer.MAX_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvSource( {"1, 2, 3", "2, 4, 5"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(Integer a1, Integer a2, Integer a3) {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(a1, a2, a3);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNoOperands() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add();

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddOneOperand() {

        //GIVEN

        //WHEN
        long result = basicCalculator.add(167);

        //THEN
        System.out.println(result);
    }

    //testcases for multiply method

    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldMultiplyNumbersGivenOperand0(int a, int b) {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(a, b);

        //THEN
        System.out.println(result);

    }

    @ParameterizedTest
    @MethodSource("numberProvider1")
    public void shouldMultiplyNumbersGivenOperand1(int a, int b) {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(a, b);

        //THEN
        System.out.println(result);

    }


    public static List<Arguments> numberProvider1() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(1, 2));
        argumentsList.add(Arguments.of(2, 1));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldMultiplyNegativeNumbers() {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(-2, -4);

        //THEN
        System.out.println(result);

    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldMultiplyBigNumbers() {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(Integer.MAX_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvSource( {"1, 2, 3", "2, 4, 5"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldMultiplyMoreThan2Operands(Integer a1, Integer a2, Integer a3) {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(a1, a2, a3);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNoOperands() {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply();

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyOneOperand() {

        //GIVEN

        //WHEN
        long result = basicCalculator.multiply(167);

        //THEN
        System.out.println(result);
    }

    //testcases for pow method

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldPowNumbersGivenOperand0(int a, int b) {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(a, b);

        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @MethodSource("numberProvider1")
    public void shouldPowNumbersGivenOperand1(int a, int b) {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(a, b);

        //THEN
        System.out.println(result);

    }


    @Tag("smoke")
    @Test
    public void shouldPowNegativeNumbers() {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(-2, -4);

        //THEN
        System.out.println(result);

    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldPowBigNumbers() {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(Integer.MAX_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @MethodSource("exponentOrBase")
    public void shouldPowExponentOrBaseNegative(int a, int b) {

        //GIVEN

        //WHEN
        double result = expertCalculator.pow(a, b);

        //THEN
        System.out.println(result);
    }

    public static List<Arguments> exponentOrBase() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(-1, 2));
        argumentsList.add(Arguments.of(2, -1));

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
        System.out.println(result);
    }

    @Test
    public void shouldFactNumbersGivenOperand1() {

        //GIVEN

        //WHEN - actiunea pe care o testez; trb sa fie una singura intr-un testcase
        long result = expertCalculator.fact(1);

        //THEN
        System.out.println(result);
    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldFactBigNumbers() {

        //GIVEN

        //WHEN
        long result = expertCalculator.fact(30);

        //THEN
        System.out.println(result);
    }


}
