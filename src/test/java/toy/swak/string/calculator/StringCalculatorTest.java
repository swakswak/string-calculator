package toy.swak.string.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author hyoseok.choi (hschoi0702@gmail.com)
 **/
class StringCalculatorTest {
    private final StringCalculator stringCalculator;

    public StringCalculatorTest() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void convertAndSum_Null_0() {
        assertEquals(0, stringCalculator.convertAndSum(null));
    }

    @Test
    void convertAndSum_Empty_0() {
        assertEquals(0, stringCalculator.convertAndSum(""));
    }

    @Test
    void convertAndSum_Space_0() {
        assertEquals(0, stringCalculator.convertAndSum(" "));
    }

    @Test
    void convertAndSum_ValidString_CalculatedIntValue() {
        assertEquals(3, stringCalculator.convertAndSum("1,2"));
        assertEquals(5, stringCalculator.convertAndSum("2,3"));
        assertEquals(6, stringCalculator.convertAndSum("1,2,3"));
    }

    @Test
    void convertAndSum_ValidStringWithSpaceWord_CalculatedIntValue() {
        assertEquals(6, stringCalculator.convertAndSum("1, 2,3"));
    }

    @Test
    void convertAndSum_InvalidString_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.convertAndSum("1,,2,3"));
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.convertAndSum("a,,2,3"));
    }

    @Test
    void convertAndSum_NegativeIntValue_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.convertAndSum("-3 "));
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.convertAndSum("-1,2,3"));
    }
}