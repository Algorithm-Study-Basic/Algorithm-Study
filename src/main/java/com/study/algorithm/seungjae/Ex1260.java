package com.study.algorithm.seungjae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1260 {

    private static boolean[] visited;
    private static int[][] arr;
    private static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        final int v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new int[1001][1001];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            final int front = Integer.parseInt(st.nextToken());
            final int back = Integer.parseInt(st.nextToken());
            arr[front][back] = 1;
            arr[back][front] = 1;
        }

        dfs(v);

        visited = new boolean[n + 1];
        System.out.println();

        bfs(v);
    }

    private static void dfs(final int number) {
        visited[number] = true;
        System.out.print(number + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[number][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }

    private static void bfs(int number) {
        Queue<Integer> q = new LinkedList<>();
        visited[number] = true;
        q.offer(number);

        while (!q.isEmpty()) {
            number = q.poll();
            System.out.print(number + " ");

            for (int i = 0; i < n + 1; i++) {
                if (!visited[i] && arr[number][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

    }

}
