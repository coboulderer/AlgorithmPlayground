package rk.algos.other;

/**
 * Various Matrix Multiplication methods
 */
public class MatrixMultiplication {

    /**
     * Brute force method -> O(n^3)
     * @param a input matrix
     * @param b input matrix
     * @return
     */
    public static int[][] bruteForceMultiply(int[][] a, int[][] b) {
        int aRows = a.length;
        int aCols = a[0].length;
        int bRows = b.length;
        int bCols = b[0].length;
        validateDimensions(aCols, bRows);
        int[][] c = new int[aRows][bCols];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                for (int k = 0; k < aCols; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * Check that Columns of A Equal to Rows of B
     * @param aCols - Cols in matrix A
     * @param bRows - Rows in matrix B
     */
    private static void validateDimensions(int aCols, int bRows) {
        if (aCols != bRows) {
            throw new IllegalArgumentException("Column size in matrix A does not match Row Size " +
                    "in matrix B");
        }
    }

    public static int[][] strassenMultiplication(int[][] a, int[][] b) {
        // TODO
        return new int[][] {{0}};
    }
}
