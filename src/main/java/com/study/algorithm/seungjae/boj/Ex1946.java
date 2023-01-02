package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 전체 테스트 케이스 수
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] grade = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                int rank = Integer.parseInt(st.nextToken());
                grade[rank] = Integer.parseInt(st.nextToken());
            }

            int count = 1; // 1등은 무조건 넣고
            int minValue = grade[1];
            for (int j = 2; j <= n; j++) {
                if (grade[j] < minValue) {
                    count++;
                    minValue = grade[j];
                }
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);
    }

}
