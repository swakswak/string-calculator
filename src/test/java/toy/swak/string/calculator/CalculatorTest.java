package toy.swak.string.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author hyoseok.choi (hschoi0702@gmail.com)
 **/
class CalculatorTest {
    @Test
    void stringCalculatorTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.convertAndSum(null));
        assertEquals(0, stringCalculator.convertAndSum(" "));
        assertEquals(0, stringCalculator.convertAndSum(""));
        assertEquals(3, stringCalculator.convertAndSum("1,2"));
        assertEquals(3, stringCalculator.convertAndSum("1:2"));
        assertEquals(6, stringCalculator.convertAndSum("1,2:3"));
        assertEquals(6, stringCalculator.convertAndSum("1, 2:3"));
        assertThrows(NumberFormatException.class, () -> stringCalculator.convertAndSum("1,,2;:3"));
        assertThrows(NumberFormatException.class, () -> stringCalculator.convertAndSum("a,,2;:3"));
    }
}