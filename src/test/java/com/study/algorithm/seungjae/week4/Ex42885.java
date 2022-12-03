package com.study.algorithm.seungjae.week4;

import java.util.Arrays;

public class Ex42885 {

    private int solution(final int[] people, final int limit) {
        Arrays.sort(people);

        int count = 0;
        int min = 0;

        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            count++;
        }

        return count;
    }

}
