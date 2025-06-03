/**
 * Demonstrates correct and incorrect uses of loop constructs to illustrate Checkstyle rules.
 */
public class LoopControl {

    /**
     * Task 1: Calculates the sum of squares of the first 10 positive integers.
     * VariableDeclarationUsageDistance rule: declare 'sum' just before use.
     *
     * @return sum of squares from 1^2 to 10^2.
     */
    public int sumOfSquares() {
        int sum = 0; // 'sum' is declared and used within 3 lines.
        for (int i = 1; i <= 10; i++) {
            sum += i * i;
        }
        return sum;
    }

    /**
     * Task 2: Prints a right-angled triangle of asterisks of height 5.
     * Ensures no empty block violations by always having non-empty loop bodies.
     */
    public void printTriangle() {
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Task 3: Demonstrates incorrect modification of loop control variable,
     * violating the ModifiedControlVariable rule.
     *
     * @return the final value of 'i' when loop exits.
     */
    public int modifyIndexIncorrectly() {
        int i = 0;
        for (i = 0; i < 5; i++) {
            i += 2; // This modification inside loop body violates ModifiedControlVariable.
        }
        return i;
    }
}
