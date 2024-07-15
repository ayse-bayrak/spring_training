import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String arg){
Assertions.assertFalse(arg.isEmpty());// I only run one test but it says->Tests passed:3
// Total 3 times (parameter numbers)
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 9})
    void testCase2(int num){
        Assertions.assertEquals(0, num%3, "failed");// I only run one test but it says->Tests failed:1, passed:2
// Total 3 times (parameter numbers) each of them is separate execution
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
   // @EmptySource // "" --> in the forth test it is like this
    //@NullSource // in 4 test --> failed java.lang.NullPointerException because null.isEmpty() does not work
    @NullAndEmptySource // in  test 4 failed-> NullPointerException, test 5 failed
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }// Test failed 1, passed 3


    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    } // it will return stringProvider() method as a parameter

    static String[] stringProvider(){
        return new String[]{"Java", "JS", "TS"};
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 20, 40",
            "30, 20, 100"
    })
    void testCase5(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1) // we skip num1, num2, result
    void testCase6(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }
}

