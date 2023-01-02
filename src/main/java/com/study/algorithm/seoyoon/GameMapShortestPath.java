package com.study.algorithm.seoyoon;

import java.util.*;

class Solution {

    static int[] x = {0,1,-1,0};
    static int[] y = {1,0,0,-1};
    static int min = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        bfs(maps);
        return min != Integer.MAX_VALUE ? min : -1;
    }

    public static void bfs(int[][] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] cur = {0,0,1};
        q.add(cur);
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] current = q.poll();

            if(current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                min = min > current[2] ? current[2] : min;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int newX = current[0] + x[i];
                int newY = current[1] + y[i];
                int count = current[2] + 1;

                if(newX >= 0 && newY >= 0 && newX < maps.length && newY < maps[0].length) {

                    if(maps[newX][newY] != 0 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        int[] newCur = new int[3];
                        newCur[0] = newX;
                        newCur[1] = newY;
                        newCur[2] = count;
                        q.add(newCur);
                    }
                }
            }
        }
    }
}
