package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SqrtTest {
    private static final double EPS = 1e-6;

    @ParameterizedTest
    @CsvSource({
        "0.0, 0.0",
        "1.0, 1.0",
        "4.0, 2.0",
        "9.0, 3.0",
        "25.0, 5.0",
        "100.0, 10.0"
    })
    void calcFindsRootsOfPerfectSquares(double input, double expected) {
        assertEquals(expected, new Sqrt(input).calc(), EPS);
    }

    @ParameterizedTest
    @CsvSource({
        "2.0, 1.414213562",
        "3.0, 1.732050807",
        "5.0, 2.236067977",
        "10.0, 3.162277660"
    })
    void calcFindsApproximateRoots(double input, double expected) {
        assertEquals(expected, new Sqrt(input).calc(), EPS);
    }

    @Test
    void constructorRejectsNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new Sqrt(-1.0));
    }

    @Test
    void averageReturnsMiddleValue() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(6.0, sqrt.average(4.0, 8.0), EPS);
    }

    @Test
    void goodAcceptsCloseGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void goodRejectsBadGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void improveUsesNewtonStep() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.05, sqrt.improve(2.5, 4.0), EPS);
    }

    @Test
    void improveHandlesZeroGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(1.0, sqrt.improve(0.0, 4.0), EPS);
    }

    @Test
    void iterReturnsInitialGuessWhenItIsGood() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.iter(3.0, 9.0), EPS);
    }

    @Test
    void iterImprovesBadGuess() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.iter(1.0, 16.0), EPS);
    }

    @Test
    void iterRepairsNonPositiveInitialGuess() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.iter(-5.0, 25.0), EPS);
    }

    @Test
    void calcWorksForSmallNumbers() {
        assertEquals(0.001, new Sqrt(0.000001).calc(), 1e-5);
    }

    @Test
    void calcWorksForLargeNumbers() {
        assertEquals(10000.0, new Sqrt(100000000.0).calc(), EPS);
    }
}
