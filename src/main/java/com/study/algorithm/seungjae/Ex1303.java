package com.study.algorithm.seungjae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1303 {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static char[][] battleGround;
    private static boolean[][] visited;
    private static int n, m;
    private static int count;
    private static int ally = 0;
    private static int enemy = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //가로
        m = Integer.parseInt(st.nextToken()); //세로


        // 전쟁터 초기화
        battleGround = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            final String line = br.readLine();
            for (int j = 0; j < n; j++) {
                battleGround[i][j] = line.charAt(j);
            }
        }


        for (int i = 0; i < m; i++) {//세로
            for (int j = 0; j < n; j++) { //가로
                // 여기 for문에서 수행되는게 모든 dfs의 진입점
                if (!visited[i][j]) { //방문하지 않았다면
                    final char color = battleGround[i][j]; // 여기서 적군,아군의 색을 잡음.
                    count = 0; // 인접 아군 초기화
                    dfs(j, i, color);

                    // 여기는 dfs 한 사이클이 완전히 끝난 상태
                    if (color == 'W') {
                        ally += count * count;
                    } else {
                        enemy += count * count;
                    }
                }
            }
        }

        System.out.println(ally + " " + enemy);
    }

    // x : 가로, y : 세로
    private static void dfs(final int x, final int y, final char color) {
        visited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if ((0 <= newX && newX < n && 0 <= newY && newY < m) && !visited[newY][newX] && battleGround[newY][newX] == color) {
                dfs(newX, newY, color);
            }
        }
    }

}
