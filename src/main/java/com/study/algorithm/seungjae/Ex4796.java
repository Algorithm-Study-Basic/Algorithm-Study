package com.study.algorithm.seungjae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;

        // 셋다 0 이 아닌경우만 동작하게 설정
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int l = Integer.parseInt(st.nextToken());
            final int p = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            final int mok = v / p;
            final int remainder = v % p;
            int value = (l * mok) + Math.min(remainder, l);

            System.out.println("Case " + index + ": " + value);
            index++;

        }
    }

}
