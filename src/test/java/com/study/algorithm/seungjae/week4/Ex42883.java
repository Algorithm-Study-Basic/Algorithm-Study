package com.study.algorithm.seungjae.week4;

public class Ex42883 {

    private String solution(final String number, final int k) {
        final StringBuilder sb = new StringBuilder();
        int index = 0;

        // 총 만들어야 하는 자리수 만큼 for-loop
        for (int i = 0; i < number.length() - k; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = index; j <= k + i; j++) {
                // 해당 자릿수 값
                final int value = number.charAt(j) - '0';
                if (max < value) {
                    max = value;
                    // max값으로 설정된 변수의 다음 index부터 시작해야 되서 1 더해줌
                    index = j + 1;
                }
            }

            sb.append(max);
        }


        return sb.toString();
    }

}
