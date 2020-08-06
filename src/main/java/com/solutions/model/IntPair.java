package com.solutions.model;

/**
 * @author majorMobilych, https://github.com/majorMobilych;
 * @see com.solutions.Solutions, public static int[] solutionNaive(int[] A, int K);
 */
public class IntPair {

    private final int numerator;
    private final int denominator;

    public IntPair(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return "{numerator: " + numerator + ", denominator: " + denominator + "}";
    }
}
