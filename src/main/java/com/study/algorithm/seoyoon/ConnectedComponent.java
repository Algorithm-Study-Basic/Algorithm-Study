package com.study.algorithm.seoyoon;
import java.util.*;
public class ConnectedComponent {
    static int N;
    static int M;
    static int count;
    static int graph[][];
    static boolean visit[];

    public static void dfs(int i) {
        visit[i] = true;
        for(int j=1; j<=N; j++) {
            if(graph[i][j] == 1 && visit[j] == false) {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        graph = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=1; i<=M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }

        for(int i=1; i<=N; i++) {
            if(!visit[i]) {
                dfs(i);
                count ++;
            }
        }

        System.out.println(count);
    }

}