package com.study.algorithm.seoyeon.week2;

import java.util.Arrays;
import java.util.Scanner;

public class Atm {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] pi = new int[n];
        for (int i = 0; i < n; i++) {
            pi[i] = scanner.nextInt();
        }
        Arrays.sort(pi);
        int add = 0;
        int result = 0;
        for (int j = 0; j < pi.length; j++) {
            add += pi[j];
            result += add;
        }

        System.out.println(result);
    }
}
