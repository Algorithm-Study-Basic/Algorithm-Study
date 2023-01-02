package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1743 {

    private static int n, m, k, temp, count;
    private static boolean[][] arr;
    private static boolean[][] visited;
    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로
        n = Integer.parseInt(st.nextToken());
        // 가로
        m = Integer.parseInt(st.nextToken());
        // 음식물 쓰레기 개수
        k = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 배열은 0부터 시작인데 좌표는 1부터 시작해서 -1함
            arr[x - 1][y - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j]) {
                    temp = 0;
                    dfs(i, j);
                    count = Math.max(count, temp);
                }
            }
        }

        System.out.println(count);


    }

    private static void dfs(final int x, final int y) {
        temp++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (0 <= newX && 0 <= newY && newX < n && newY < m) {
                if (!visited[newX][newY] && arr[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }

}
