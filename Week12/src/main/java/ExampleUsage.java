/**
 * Contains practical examples of data manipulation using loops.
 */
public class ExampleUsage {

    /**
     * Task 4: Filters and counts even numbers in an array of integers 1 to 20.
     * Uses a foreach loop and adheres to all Checkstyle rules.
     *
     * @return count of even numbers found.
     */
    public int filterAndCountEvenNumbers() {
        int[] numbers = new int[20];
        for (int idx = 0; idx < numbers.length; idx++) {
            numbers[idx] = idx + 1;
        }
        int count = 0; // 'count' declared close to its usage.
        for (int num : numbers) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Task 5: Calculates the sum of the diagonal elements of a 3x3 matrix.
     * Ensures loop variables are correctly scoped and no distance violations occur.
     *
     * @return sum of diagonal elements.
     */
    public int matrixDiagonalSum() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int sum = 0; // declared and used within 3 lines.
        for (int row = 0; row < 3; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }
}
