package com.mycompany.app;

public class Sqrt {
    private static final double DEFAULT_PRECISION = 1e-8;
    private static final int MAX_STEPS = 1000;

    private final double requiredPrecision;
    private final double value;

    public Sqrt(double arg) {
        if (arg < 0.0) {
            throw new IllegalArgumentException("argument must be non-negative");
        }
        this.value = arg;
        this.requiredPrecision = DEFAULT_PRECISION;
    }

    public double mean(double x, double y) {
        return (x + y) * 0.5;
    }

    public boolean isAccurate(double guess, double x) {
        return computeSquaredError(guess, x) <= requiredPrecision;
    }

    public double nextApproximation(double guess, double x) {
        if (guess == 0.0) {
            return 1.0;
        }
        return mean(guess, x / guess);
    }

    public double iter(double guess, double x) {
        if (x == 0.0) {
            return 0.0;
        }

        double current = getInitialGuess(guess, x);
        for (int step = 0; step < MAX_STEPS; step++) {
            if (isAccurate(current, x)) {
                return current;
            }
            current = nextApproximation(current, x);
        }
        return current;
    }

    public double calc() {
        return iter(getInitialGuess(value, value), value);
    }

    private double computeSquaredError(double guess, double x) {
        return Math.abs(guess * guess - x);
    }

    private double getInitialGuess(double guess, double x) {
        if (guess > 0.0) {
            return guess;
        }
        return x >= 1.0 ? x : 1.0;
    }
}