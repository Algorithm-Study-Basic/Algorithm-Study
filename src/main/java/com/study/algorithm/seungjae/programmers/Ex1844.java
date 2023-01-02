package com.study.algorithm.seungjae.programmers;

import java.util.LinkedList;
import java.util.Queue;

class Ex1844 {
    private int[] dx = new int[]{1, 0, -1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};
    private boolean[][] visited;
    private Queue<Node> q = new LinkedList<>();
    private int n, m;

    public int solution(final int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return dfs(maps);
    }

    private int dfs(final int[][] maps) {
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            final Node node = q.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return node.distance;
            }

            for (int i = 0; i < 4; i++) {
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];

                if (0 <= newX && newX < n && 0 <= newY && newY < m) {
                    if (!visited[newX][newY] && maps[newX][newY] == 1) {
                        visited[newX][newY] = true;
                        q.offer(new Node(newX, newY, node.distance + 1));
                    }
                }

            }

        }

        return -1;
    }

    private static class Node {
        private final int x;
        private final int y;
        private final int distance;

        public Node(final int x, final int y, final int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }
}
