import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testAdd() throws InvalidInputException {
        assertEquals(5.0, Calculator.add(2, 3));
        assertEquals(-1.0, Calculator.add(2, -3));
    }

    @Test
    void testSubtract() throws InvalidInputException {
        assertEquals(-1.0, Calculator.subtract(2, 3));
        assertEquals(5.0, Calculator.subtract(2, -3));
    }

    @Test
    void testMultiply() throws InvalidInputException {
        assertEquals(6.0, Calculator.multiply(2, 3));
        assertEquals(0.0, Calculator.multiply(0, 100));
    }

    @Test
    void testDivide() throws InvalidInputException {
        assertEquals(2.5, Calculator.divide(5, 2));
        assertEquals(-2.0, Calculator.divide(6, -3));
    }

    @Test
    void testDivideByZeroThrowsArithmeticException() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> Calculator.divide(10, 0));
        assertEquals("Ділити на нуль не можна!", ex.getMessage());
    }

    @Test
    void testNaNThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> Calculator.add(Double.NaN, 1));
        assertThrows(InvalidInputException.class, () -> Calculator.subtract(1, Double.NaN));
    }

    @Test
    void testInfinityThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class,
                () -> Calculator.multiply(Double.POSITIVE_INFINITY, 2));
        assertThrows(InvalidInputException.class,
                () -> Calculator.divide(1, Double.NEGATIVE_INFINITY));
    }

    @Test
    void testInvalidInputMessage() {
        InvalidInputException ex = assertThrows(InvalidInputException.class,
                () -> Calculator.add(Double.NaN, 1));
        assertTrue(ex.getMessage().contains("NaN"));
    }

    @Test
    void testParseInvalidStringThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> Double.parseDouble("abc"));
        assertThrows(NumberFormatException.class, () -> Double.parseDouble(""));
        assertThrows(NumberFormatException.class, () -> Double.parseDouble("12abc"));
    }
}