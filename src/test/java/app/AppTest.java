package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    double eps = 0.00000001;

    @Test
    public void testAverage() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.0, s.average(1.0, 3.0), eps);
    }

    @Test
    public void testGoodTrue() {
        Sqrt s = new Sqrt(4.0);
        assertTrue(s.good(2.0, 4.0));
    }

    @Test
    public void testGoodFalse() {
        Sqrt s = new Sqrt(4.0);
        assertFalse(s.good(2.1, 4.0));
    }

    @Test
    public void testImprove() {
        Sqrt s = new Sqrt(2.0);
        assertEquals(1.5, s.improve(1.0, 2.0), eps);
    }

    @Test
    public void testCalc4() {
        assertEquals(2.0, new Sqrt(4.0).calc(), eps);
    }

    @Test
    public void testCalc9() {
        assertEquals(3.0, new Sqrt(9.0).calc(), eps);
    }

    @Test
    public void testCalc2() {
        assertEquals(1.41421356, new Sqrt(2.0).calc(), eps);
    }

    @Test
    public void testCalcTwentyFive() {
        assertEquals(5.0, new Sqrt(25.0).calc(), eps);
    }

    @Test
    public void testCalcOne() {
        assertEquals(1.0, new Sqrt(1.0).calc(), eps);
    }

    @Test
    public void testCalc100() {
        assertEquals(10.0, new Sqrt(100.0).calc(), eps);
    }

    @Test
    public void testCalcLargeNumber() {
        assertEquals(1000.0, new Sqrt(1000000.0).calc(), eps);
    }

    @Test
    public void testCalcSmallNumber() {
        assertEquals(0.2, new Sqrt(0.04).calc(), eps);
    }

    @Test
    public void testCalcDoublePrecision() {
        assertEquals(0.5, new Sqrt(0.25).calc(), eps);
    }

    @Test
    public void testCalcProperty() {
        double x = 5.0;
        double result = new Sqrt(x).calc();
        assertEquals(x, result * result, eps);
    }

    @Test
    public void testCalcAnotherSquare() {
        assertEquals(12.0, new Sqrt(144.0).calc(), eps);
    }
}