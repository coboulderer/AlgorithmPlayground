package rk.algos.other;

/**
 * Performs multiplication using the Karatsuba method
 */
public class KaratsubaMultiplication {

    public int multiply(int a, int b) {
        if (a < 10 || b < 10) {
            return a * b;
        }
        int divisor = getDivisor(a, b);
        int aHigh = getHighValue(a, divisor);
        int aLow = getLowValue(a, divisor);
        int bHigh = getHighValue(b, divisor);
        int bLow = getLowValue(b, divisor);
        int z0 = multiply(aLow, bLow);
        int z1 = multiply(aHigh + aLow, bHigh + bLow);
        int z2 = multiply(aHigh, bHigh);
        return (int)Math.pow(10, divisor * 2) * z2 + (int)Math.pow(10, divisor) * (z1 - z2 - z0)
                + z0;
    }

    private int getLowValue(int a, int divisor) {

        return a % ((int)Math.pow(10, divisor));
    }

    private int getHighValue(int a, int divisor) {

        return a / ((int)Math.pow(10, divisor));
    }

    private int getDivisor(int a, int b) {
        int max = Integer.max(a, b);
        return (int)Math.log10(max) / 2 + 1;
    }
}
