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
    void testCase1(int num){
        Assertions.assertEquals(0, num%3, "failed");// I only run one test but it says->Tests failed:1, passed:2
// Total 3 times (parameter numbers) each of them is separate execution
    }

}
