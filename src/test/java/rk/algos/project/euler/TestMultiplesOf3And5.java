package rk.algos.project.euler;

import org.junit.Assert;
import org.junit.Test;

import rk.AlgoTestingBase;

public class TestMultiplesOf3And5 extends AlgoTestingBase {

    @Test
    public void testGetMultiples() {
        MultiplesOf3And5 multiples = new MultiplesOf3And5();
        int sum = multiples.findMultiples();
        print(Integer.toString(sum));
        Assert.assertEquals(233168, sum);
    }
}
