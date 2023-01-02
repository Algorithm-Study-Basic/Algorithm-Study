package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 개수
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        // 초기화 n-1 만큼의 리스트
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // 인접 리스트 구현
        for (int i = 0; i < n - 1; i++) {
            final String[] s = br.readLine().split(" ");
            int number1 = Integer.parseInt(s[0]) - 1;
            int number2 = Integer.parseInt(s[1]) - 1;

            list.get(number1).add(number2);
            list.get(number2).add(number1);
        }

        boolean[] visited = new boolean[n];
        int[] result = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            final int value = q.remove();

            for (int node : list.get(value)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.offer(node);
                    result[node] = value;
                }
            }

        }

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i] + 1);
        }
    }
}
