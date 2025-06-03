/**
 * Main application class that demonstrates the functionality of LoopControl and ExampleUsage.
 */
public class App {

    /**
     * Application entry point.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        LoopControl lc = new LoopControl();
        ExampleUsage eu = new ExampleUsage();

        // Demonstrate sumOfSquares
        int sumSquares = lc.sumOfSquares();
        System.out.println("Sum of squares (1-10): " + sumSquares);

        // Demonstrate printTriangle
        System.out.println("Triangle of asterisks:");
        lc.printTriangle();

        // Demonstrate incorrect loop control modification
        int finalIndex = lc.modifyIndexIncorrectly();
        System.out.println("Final index after incorrect modification: " + finalIndex);

        // Demonstrate filtering and counting even numbers
        int evenCount = eu.filterAndCountEvenNumbers();
        System.out.println("Number of even integers between 1 and 20: " + evenCount);

        // Demonstrate matrix diagonal sum
        int diagonalSum = eu.matrixDiagonalSum();
        System.out.println("Sum of diagonal elements of 3x3 matrix: " + diagonalSum);
    }
}
