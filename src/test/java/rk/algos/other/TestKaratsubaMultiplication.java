package rk.algos.other;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Test Class for KaratsubaMultiplication
 */
public class TestKaratsubaMultiplication {

    KaratsubaMultiplication karatsubaMultiplication;

    @Before
    public void setup() {
        karatsubaMultiplication = new KaratsubaMultiplication();
    }

    @Test
    public void testMultiplySingleDigitNumbers() {
        int product = karatsubaMultiplication.multiply(4, 5);
        assertThat(product, is(equalTo(20)));
    }

    @Test
    public void testMultiplyNumbersLargerThanTen() {
        int product = karatsubaMultiplication.multiply(10, 10);
        assertThat(product, is(equalTo(100)));
    }

    @Test
    public void testMultiplyNumbersThousands() {
        int product = karatsubaMultiplication.multiply(1234, 5678);
        assertThat(product, is(equalTo(7006652)));
    }

    @Test
    public void testMultiplyNumbersDiffLength() {
        int product = karatsubaMultiplication.multiply(1234, 56789);
        assertThat(product, is(equalTo(70077626)));
    }
}

