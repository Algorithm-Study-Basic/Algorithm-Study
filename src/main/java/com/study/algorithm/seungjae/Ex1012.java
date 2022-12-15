package com.study.algorithm.seungjae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1012 {
    private static int[][] field;
    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private static boolean[][] visited;
    private static int m;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 테스트 케이스 수
        int count = Integer.parseInt(br.readLine());
        //답을 도출하는 변수
        int answer;

        // 테스트 케이스 수 만큼 반복하며 dfs
        for (int i = 0; i < count; i++) {
            answer = 0;
            // 10가로 8세로 17 심는수
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            field = new int[m][n];
            visited = new boolean[m][n];

            // 배추 심는 수
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int column = Integer.parseInt(st.nextToken());
                field[row][column] = 1; //배추를 심음
            }


            //dfs알고리즘 시작
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (field[j][l] == 1 && !visited[j][l]) {
                        dfs(j, l);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }

    }

    private static void dfs(final int cx, final int cy) {
        //방문처리
        visited[cx][cy] = true;

        // dx, dy 길이는 고정 4이다.
        for (int i = 0; i < 4; i++) {
            int newX = cx + dx[i];
            int newY = cy + dy[i];

            if (0 <= newX && 0 <= newY && newX < m && newY < n) {
                if (!visited[newX][newY] && field[newX][newY] == 1) {
                    dfs(newX, newY);
                }
            }
        }
    }

}
