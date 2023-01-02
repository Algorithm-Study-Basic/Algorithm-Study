package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex7576 {

    private static int m, n;
    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private static int[][] boxes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        boxes = new int[n][m];
        final Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                boxes[i][j] = Integer.parseInt(st.nextToken());
                if (boxes[i][j] == 1) {
                    q.offer(new Tomato(i, j));
                }
            }
        }

        System.out.println(bfs(q));
    }

    private static int bfs(final Queue<Tomato> q) {
        while (!q.isEmpty()) {
            final Tomato tomato = q.poll();
            int x = tomato.x;
            int y = tomato.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (boxes[nx][ny] == 0) {
                        q.offer(new Tomato(nx, ny));
                        boxes[nx][ny] = boxes[x][y] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (boxes[i][j] == 0) {
                    return -1;
                }

                result = Math.max(result, boxes[i][j]);
            }
        }

        if (result == 1) {
            return 0;
        }

        return result - 1;
    }

    private static class Tomato {

        private final int x;
        private final int y;

        public Tomato(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

    }

}

