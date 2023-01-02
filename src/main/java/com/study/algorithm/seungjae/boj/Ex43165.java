package com.study.algorithm.seungjae.boj;

public class Ex43165 {
    private static int count = 0;
    private static int[] globalNumbers = null;
    private static int globalTarget = 0;

    public int solution(final int[] numbers, final int target) {
        int answer = 0;
        globalNumbers = numbers;
        globalTarget = target;
        dfs(0, 0);

        answer = count;
        count = 0;
        return answer;
    }

    public void dfs(int index, int sum) {
        if (index == globalNumbers.length) {
            if (sum == globalTarget) {
                count++;
            }
            return;
        }

        dfs(index + 1, sum + globalNumbers[index]);
        dfs(index + 1, sum - globalNumbers[index]);
    }
}
