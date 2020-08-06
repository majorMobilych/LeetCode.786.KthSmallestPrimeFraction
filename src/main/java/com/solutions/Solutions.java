package com.solutions;

import com.solutions.model.IntPair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author majorMobilych, https://github.com/majorMobilych;
 */
public final class Solutions {

    private Solutions() {
        throw new AssertionError("Non-instantiating class");
    }

    public static int[] solutionNaive(int[] A, int K) {
        int arrayLength = A.length;

        IntPair[] fractions = new IntPair[arrayLength * (arrayLength - 1) / 2];
        int position = 0;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                fractions[position] = new IntPair(A[i], A[j]);
                position++;
            }
        }

        Arrays.sort(fractions, Comparator.comparingDouble(ip -> (double) ip.getNumerator() / ip.getDenominator()));

        IntPair kthSortedPair = fractions[K - 1];
        int numerator = kthSortedPair.getNumerator();
        int denominator = kthSortedPair.getDenominator();

        return new int[]{numerator, denominator};
    }

    public static int[] solution(int[] A, int K) {
        int n = A.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> A[o1[0]] * A[o2[1]] - A[o2[0]] * A[o1[1]]);
        for (int i = 0; i < n - 1; i++) {
            priorityQueue.add(new int[]{i, n - 1});
        }
        for (int i = 0; i < K - 1; i++) {
            int[] pop = priorityQueue.remove();
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                priorityQueue.add(pop);
            }
        }

        int[] peek = priorityQueue.peek();
        return new int[]{A[Objects.requireNonNull(peek)[0]], A[peek[1]]};
    }
}

