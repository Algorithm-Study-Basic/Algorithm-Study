package com.study.algorithm.seungjae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pair> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        final int[] moveX = new int[]{1, 0, -1, 0};
        final int[] moveY = new int[]{0, 1, 0, -1};

        int[][] distance = new int[n][m];
        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(arr[j]);
            }
        }

        q.offer(new Pair(0, 0));
        distance[0][0] = 0;

        while (!q.isEmpty()) {
            final Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = moveX[i] + p.x;
                int newY = moveY[i] + p.y;

                if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
                    continue;
                }

                if (maze[newX][newY] != 1 || distance[newX][newY] >= 0) {
                    continue;
                }
                distance[newX][newY] = distance[p.x][p.y] + 1;
                q.offer(new Pair(newX, newY));
            }
        }

        System.out.println(distance[n - 1][m - 1] + 1);
    }

    private record Pair(int x, int y) {
    }

}
