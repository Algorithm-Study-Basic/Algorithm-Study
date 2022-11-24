package com.study.algorithm.seungjae.week2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 각 자식 i는 자식이 만족할 쿠키의 최소 크기인 배열 인자 g[i]를 가진다.
 * 각 쿠키 j의 크기는 s[j]입니다.
 * s[j] >= g[i]이면 쿠키 j를 자식 i에 할당할 수 있다면 쿠키를 받을 수 있다.
 * 쿠키를 받는 애들 명수를 출력
 */
class AssignCookie {

    @MethodSource
    @ParameterizedTest
    void solution(final int[] g, final int[] s, final int expected) {
        final int actual = findContentChildren(g, s);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> solution() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[]{1, 1}, 1),
            Arguments.of(new int[]{1, 2}, new int[]{1, 2, 3}, 2),
            Arguments.of(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}, 2)
        );
    }

    private int findContentChildren(final int[] g, final int[] s) {
        int result = 0;
        int i = 0;
        int j = 0;
        // g나 s가 내림차순으로 오는 때가 있음
        Arrays.sort(g);
        Arrays.sort(s);

        while (i <= g.length - 1 && j <= s.length - 1) {
            if (g[i] <= s[j]) {
                result++;
                i++;
            }
            j++;
        }

        return result;
    }

}
