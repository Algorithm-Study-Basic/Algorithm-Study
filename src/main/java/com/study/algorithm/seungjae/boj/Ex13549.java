package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex13549 {

    private static int n;
    private static int k;
    private static boolean[] visited = new boolean[100_001];
    private static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(minTime);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            final Node node = q.poll();
            visited[node.x] = true;

            if (node.x == k) {
                minTime = Math.min(minTime, node.time);
            }

            if (node.x + 1 <= 100_000 && !visited[node.x + 1]) {
                q.offer(new Node(node.x + 1, node.time + 1));
            }

            if (node.x - 1 >= 0 && !visited[node.x - 1]) {
                q.offer(new Node(node.x - 1, node.time + 1));
            }

            if (node.x * 2 <= 100_000 && !visited[node.x * 2]) {
                q.offer(new Node(node.x * 2, node.time));
            }

        }

    }

    private static class Node {

        private final int x;
        private final int time;

        public Node(final int x, final int time) {
            this.x = x;
            this.time = time;
        }

    }

}
