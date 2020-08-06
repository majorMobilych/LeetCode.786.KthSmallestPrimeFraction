package com.app;

import com.solutions.Solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author majorMobilych, https://github.com/majorMobilych;
 * @see com.solutions.Solutions,public static int[] solution(int[] A, int K);
 */
public class RunApplication {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter array. Input type : a[0] a[1] a[2] ... :");
        try {
            String line = bufferedReader.readLine();

            String[] numbersAsStrings = line.split("\\s+");

            int[] A = new int[numbersAsStrings.length];
            for (int i = 0; i < numbersAsStrings.length; i++) {
                A[i] = Integer.parseInt(numbersAsStrings[i]);
            }

            System.out.println("Enter number k:");
            int K = Integer.parseInt(bufferedReader.readLine());

            int[] solution = Solutions.solution(A, K);

            System.out.println("The result array is:");
            System.out.println(Arrays.toString(solution));
        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input format. Re - run the app");

            e.printStackTrace();
        }
    }
}
