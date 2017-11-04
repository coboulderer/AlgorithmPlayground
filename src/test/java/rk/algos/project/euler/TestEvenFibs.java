package rk.algos.project.euler;

import org.junit.Assert;
import org.junit.Test;

import rk.AlgoTestingBase;

public class TestEvenFibs extends AlgoTestingBase {

    @Test
    public void testCalcFibs() {
        EvenFibs evenFibs = new EvenFibs();
        int sum = evenFibs.calcEvenFibsLessThanFourMillion();
        Assert.assertEquals(4613732, sum);
        print(Integer.toString(sum));
    }
}
