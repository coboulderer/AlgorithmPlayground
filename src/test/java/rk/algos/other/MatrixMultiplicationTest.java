package rk.algos.other;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MatrixMultiplicationTest {

    @Test
    public void testOneByOneBruteForce() {
        int[][] a = {{5}};
        int[][] b = {{8}};
        int[][] product = MatrixMultiplication.bruteForceMultiply(a, b);
        assertThat(product[0][0], is(equalTo(40)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixRowAndColError() {
        int[][] a = {{5,6,8}};
        int[][] b = {{8}};
        MatrixMultiplication.bruteForceMultiply(a, b);
    }

    @Test
    public void testTwoByTwoBruteForce() {
        int[][] a = {{5,4},{3,7}};
        int[][] b = {{2,9},{6,5}};
        int[][] product = MatrixMultiplication.bruteForceMultiply(a, b);
        assertThat(product, is(equalTo(new int[][] {{34, 65}, {48, 62}})));
    }

    @Test
    public void testRowByColBruteForce() {
        int[][] a = {{5,4,6}};
        int[][] b = {{7},{8},{9}};
        int[][] product = MatrixMultiplication.bruteForceMultiply(a, b);
        assertThat(product, is(equalTo(new int[][] {{121}})));
    }
}
