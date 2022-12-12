package com.study.algorithm.seoyeon.week6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Rope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), w = 0;

        Integer[] weigh = new Integer[n];
        for (int i = 0; i < n; i++)
            weigh[i] = scan.nextInt();
        Arrays.sort(weigh, Collections.reverseOrder());

        for (int k = 1; k <= n; k++)
            w = Math.max(w, weigh[k - 1] * k);
        System.out.println(w);
    }
}