package rk.algos.project.euler;

public class EvenFibs {

    public int calcEvenFibsLessThanFourMillion() {
        int sum = 0;
        int fibNumber = 1;
        int lastFib = 1;
        while (fibNumber <= 4000000){
            int temp = fibNumber;
            fibNumber += lastFib;
            lastFib = temp;
            if (fibNumber % 2 == 0) {
                sum += fibNumber;
            }
        }
        return sum;
    }
}
