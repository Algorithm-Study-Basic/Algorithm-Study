package com.study.algorithm.seungjae.week2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LemonadeChange {

    @Test
    void test() {
        assertThat(lemonadeChange(new int[]{5, 5, 5, 10, 20})).isTrue();
    }

    private boolean lemonadeChange(final int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount > 0) {
                    // 10원짜리 받았고
                    tenCount++;
                    // 5원짜리 뺌
                    fiveCount--;
                } else {
                    return false;
                }
            } else {
                // 20원일때
                if (fiveCount >= 3 && tenCount == 0) {
                    fiveCount -= 3;
                } else if (tenCount >= 1 && fiveCount >= 1) {
                    tenCount--;
                    fiveCount--;
                } else {
                    return false;
                }

            }
        }
        return true;
    }

}
