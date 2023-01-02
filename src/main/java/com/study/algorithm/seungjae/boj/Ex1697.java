package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1697 {

    private static int[] visited = new int[100001];
    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(n, k));
    }

    private static int bfs(final int n, final int k) {
        q.offer(n);
        visited[n] = 1;

        while (!q.isEmpty()) {

            final int temp = q.poll();
            if (temp == k) {
                // visited 를 0으로 초기화해놓고 1로 방문처리를 시작하기 때문에
                // 1이라는 횟수 1번을 빼주어야 한다.
                return visited[temp] - 1;
            }

            if (0 <= temp - 1 && visited[temp - 1] == 0) {
                visited[temp - 1] = visited[temp] + 1;
                q.offer(temp - 1);
            }

            if (temp + 1 <= 100_000 && visited[temp + 1] == 0) {
                visited[temp + 1] = visited[temp] + 1;
                q.offer(temp + 1);
            }

            if (temp * 2 <= 100_000 && visited[temp * 2] == 0) {
                visited[temp * 2] = visited[temp] + 1;
                q.offer(temp * 2);
            }
        }

        return -1;
    }

}
