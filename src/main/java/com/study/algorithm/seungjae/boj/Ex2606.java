package com.study.algorithm.seungjae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex2606 {
    static int count = 0;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());

        visited = new boolean[computer + 1];

        for (int i = 0; i < computer + 1; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;

        for (int i = 0; i < connect; i++) {
            st = new StringTokenizer(br.readLine());
            final int v1 = Integer.parseInt(st.nextToken());
            final int v2 = Integer.parseInt(st.nextToken());

            // 연결된 노드가 없는 경우도 있기 때문에 서로에게 값을 할당해준다.
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        dfs(1); // 1번 컴퓨터를 통해 감염

        System.out.println(count);

    }

    private static void dfs(final int number) {
        visited[number] = true;

        for (int i = 0; i < list.get(number).size(); i++) {
            int nextNode = list.get(number).get(i);
            if (!visited[nextNode]) {
                count++;
                dfs(nextNode);
            }
        }

    }

}
