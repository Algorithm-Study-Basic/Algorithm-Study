package com.study.algorithm.seungjae.week2;

class JumpGame2 {

    private int jump(final int[] nums) {

        int endIndex = 0;
        int result = 0;
        int max = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            //마지막인덱스는 끝에 도착이라 한번더 루프를 수행해선 안됨.
            endIndex = Math.max(i + nums[i], endIndex);

            if (i == max) {
                result++;
                max = endIndex;
            }

        }

        return result;
    }

}
