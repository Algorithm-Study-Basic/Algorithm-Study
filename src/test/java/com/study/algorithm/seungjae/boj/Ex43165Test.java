package com.study.algorithm.seungjae.boj;

import static org.assertj.core.api.Assertions.assertThat;
import com.study.algorithm.seungjae.boj.Ex43165;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Ex43165Test {

    private Ex43165 ex = new Ex43165();

    @ParameterizedTest
    @MethodSource
    void solution(final int[] numbers, final int target, final int expected) {
        final int actual = ex.solution(numbers, target);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> solution() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 1, 1, 1}, 3, 5),
            Arguments.of(new int[]{4, 1, 2, 1}, 4, 2)
        );
    }

}
