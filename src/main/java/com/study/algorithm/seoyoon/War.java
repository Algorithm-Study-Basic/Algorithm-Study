package com.study.algorithm.seoyoon;

import java.io.*;
import java.util.*;

public class War {
    static int N, M;
    static int[][] mtx;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int dfs(int color, int y, int x) {
        int sum = 1;
        mtx[y][x] = 0;    // 재 탐색 방지
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (mtx[ny][nx] == color) {
                sum += dfs(color, ny, nx);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mtx = new int[M + 2][N + 2];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken().toString();
            for (int s = 0; s < str.length(); s++) {
                if (str.charAt(s) == 'W') mtx[i][s + 1] = 1;
                else mtx[i][s + 1] = -1;
            }
        }

        int W = 0, B = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int color = mtx[i][j];
                if (color == 0) continue;
                int x = dfs(color, i, j);
                x *= x;
                if (color == 1)    // 아군
                    W += x;
                else                // 적군
                    B += x;
            }
        }
        System.out.println(W + " " + B);
    }

}
