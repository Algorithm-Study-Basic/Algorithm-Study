package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex2667 {

    private static int[][] arr;
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};
    private static boolean[][] visited = new boolean[25][25]; // 최대가 25
    private static int apartNumber = 0;
    private static int[] answer = new int[25 * 25];
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            final String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    apartNumber++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(apartNumber);

        for (int i : answer) {
            if (i > 0) {
                System.out.println(i);
            }
        }

    }

    private static void dfs(final int x, final int y) {
        visited[x][y] = true;
        answer[apartNumber]++;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (0 <= newX && newX < n && 0 <= newY && newY < n) {
                if (arr[newX][newY] == 1 && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }

    }

}
