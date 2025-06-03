import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Smoke tests to verify basic functionality of LoopControl and ExampleUsage.
 */
public class SmokeTest {

    /**
     * Tests sumOfSquares returns correct value: 385.
     */
    @Test
    public void testSumOfSquares() {
        LoopControl lc = new LoopControl();
        assertEquals(385, lc.sumOfSquares());
    }

    /**
     * Tests modifyIndexIncorrectly. Loop starts at 0, increments by 1, then by 2 inside,
     * and repeats until i >= 5. Final i should be greater than or equal to 5; actual final value is 6.
     */
    @Test
    public void testModifyIndexIncorrectly() {
        LoopControl lc = new LoopControl();
        int result = lc.modifyIndexIncorrectly();
        assertEquals(6, result);
    }

    /**
     * Tests filterAndCountEvenNumbers returns 10 (even numbers between 1 and 20).
     */
    @Test
    public void testFilterAndCountEvenNumbers() {
        ExampleUsage eu = new ExampleUsage();
        assertEquals(10, eu.filterAndCountEvenNumbers());
    }

    /**
     * Tests matrixDiagonalSum returns 1+5+9 = 15.
     */
    @Test
    public void testMatrixDiagonalSum() {
        ExampleUsage eu = new ExampleUsage();
        assertEquals(15, eu.matrixDiagonalSum());
    }
}
