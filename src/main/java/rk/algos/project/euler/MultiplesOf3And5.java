package rk.algos.project.euler;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class MultiplesOf3And5 {

    public int findMultiples() {
//        int sumOfMultiplesOfThree = 3 * IntStream.rangeClosed(1, 333).sum();
//        int sumOfMultiplesOfFive = 5 * IntStream.rangeClosed(1, 199).sum();
//        return sumOfMultiplesOfThree + sumOfMultiplesOfFive;
        int sum = 0;
        for (int i = 1; i <= 333; i++) {
            int threeMult;
            int fiveMult;
            if (i <= 199 ) {
                fiveMult = 5 * i;
            } else {
                fiveMult = 0;
            }

            if (i % 5 == 0 ) {
                threeMult = 0;
            } else {
                threeMult = 3 * i;
            }
            sum += fiveMult + threeMult;
        }
        return sum;
    }
}
