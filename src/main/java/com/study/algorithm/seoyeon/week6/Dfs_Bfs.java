package com.study.algorithm.seoyeon.week6;

import java.util.*;
import java.io.*;

public class Dfs_Bfs {
    // 함수에 사용할 변수들
    static int node;
    static int line;
    static int start;
    static ArrayList<Integer> arr[];
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new ArrayList[node + 1]; // 좌표를 그대로 받아들이기 위해 +1 사용
        check = new boolean[node + 1];
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 0; i < arr.length; i++) {// 간선 열결 상태 저장
            Collections.sort(arr[i]);
        }
        dfs(start);
        check = new boolean[node + 1];
        sb.append("\n");
        bfs(start);
        System.out.println(sb);
    }

    public static void dfs(int index) { // 시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출해준다
        check[index] = true;
        sb.append(index + " ");
        for (int i : arr[index]) {// i의 변수에 현재 방문한 노드에 해당하는 리스트에 담겨있는 값들을 하나씩 할당
            if (!check[i]) {
                dfs(i); // 다음 방문할 노드 값으로 바꾸어 재귀 함수 실행
            }
        }
    }

    public static void bfs(int index) {  // Queue가 empty 될 때까지 반복하고 방문 정점을 확인, 출력 후 Queue에 넣어 순서대로 확인해준다
        check[index] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        //
        while (!q.isEmpty()) {
            int a = q.poll();
            sb.append(a + " ");
            for (int i : arr[a]) {
                if (!check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}