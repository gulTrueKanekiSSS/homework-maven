package pro.sky.homeworkmaven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class CalculatorServiceTests {
    private final CalculatorService calculatorService = new CalculatorService();

    private static final String ADD_RESULT = "5 + 5 = 10";
    private static final String MINUS_RESULT = "5 - 5 = 0";
    private static final String MULTIPLY_RESULT = "5 * 5 = 25";
    private static final String DIVIDE_RESULT = "5 / 5 = 1";


    @Test
    void plusOperationTest(){
        Assertions.assertEquals(ADD_RESULT, calculatorService.plusOperation(5, 5));
    }

    @Test
    void minusOperationTest(){
        Assertions.assertEquals(MINUS_RESULT, calculatorService.minusOperation(5, 5));
    }

    @Test
    void multipleOperationTest(){
        Assertions.assertEquals(MULTIPLY_RESULT, calculatorService.multipleOperation(5, 5));
    }

    @Test
    void divideOperationTest(){
        Assertions.assertEquals(DIVIDE_RESULT, calculatorService.divideOperation(5, 5));
    }

    @Test
    void divisionByZero(){
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculatorService.divideOperation(10, 0)
        );

        Assertions.assertEquals("Нельзя делить на 0", exception.getMessage());
    }

    public static Stream<Arguments> paramsForTestsPlus(){
        return Stream.of(
        Arguments.of(5, 5, "5 + 5 = 10"),
        Arguments.of(10, 10, "10 + 10 = 20"),
        Arguments.of(-1, -1, "-1 + -1 = -2")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForTestsPlus")
    public void shouldReturnCorrectAnsForPlus(Integer num1, Integer num2, String expected){
        Assertions.assertEquals(expected, calculatorService.plusOperation(num1, num2));
    }

    public static Stream<Arguments> paramsForTestsMinus(){
        return Stream.of(
                Arguments.of(5, 5, "5 - 5 = 0"),
                Arguments.of(0, 10, "0 - 10 = -10"),
                Arguments.of(-1, -1, "-1 - -1 = 0")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForTestsMinus")
    public void shouldReturnCorrectAnsForMinus(Integer num1, Integer num2, String expected){
        Assertions.assertEquals(expected, calculatorService.minusOperation(num1, num2));
    }

    public static Stream<Arguments> paramsForTestsMultiply(){
        return Stream.of(
                Arguments.of(5, 5, "5 * 5 = 25"),
                Arguments.of(5, 0, "5 * 0 = 0"),
                Arguments.of(-1, -1, "-1 * -1 = 1")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForTestsMultiply")
    public void shouldReturnCorrectAns(Integer num1, Integer num2, String expected){
        Assertions.assertEquals(expected, calculatorService.multipleOperation(num1, num2));
    }

    public static Stream<Arguments> paramsForTestsDivide(){
        return Stream.of(
                Arguments.of(5, 5, "5 / 5 = 1"),
                Arguments.of(0, 10, "0 / 10 = 0"),
                Arguments.of(-10, 2, "-10 / 2 = -5")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForTestsDivide")
    public void shouldReturnCorrectAnsDivide(Integer num1, Integer num2, String expected){
        Assertions.assertEquals(expected, calculatorService.divideOperation(num1, num2));
    }


}
