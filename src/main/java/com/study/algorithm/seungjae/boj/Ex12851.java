package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex12851 {

    private static int count = 0;
    private static int min = Integer.MAX_VALUE;
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
        } else {
            bfs();
            System.out.println(min);
            System.out.println(count);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100_001];

        q.offer(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            // 5
            int now = q.poll();
            // MAX < 5 false
            if (min < visited[now]) {
                return;
            }

            // 4, 6, 10
            int[] move = new int[]{now - 1, now + 1, now * 2};
            for (int next : move) {
                // next = 4 k = 17
                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (next == k) {
                    min = visited[now];
                    count++;
                }

                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    visited[next] = visited[now] + 1;
                    q.offer(next);
                }
            }
        }

    }

}
