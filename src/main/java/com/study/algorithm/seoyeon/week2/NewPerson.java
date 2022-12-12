package com.study.algorithm.seoyeon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewPerson {
    static int res[], newperson, n, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(bf.readLine());
        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(bf.readLine());
            res = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(bf.readLine());
                idx = Integer.parseInt(st.nextToken());
                res[idx] = Integer.parseInt(st.nextToken());
            }
            check();
            System.out.println(newperson);
        }
    }

    static void check() {
        newperson = 1;
        int tmp = res[1];
        for (int i = 2; i <= n; i++) {
            if (res[i] < tmp) {
                newperson++;
                tmp = res[i];
            }
        }

    }

}