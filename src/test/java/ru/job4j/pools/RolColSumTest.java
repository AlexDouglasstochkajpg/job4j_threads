package ru.job4j.pools;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RolColSumTest {

    @Test
    void sum() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Sums[] expected = new Sums[]{new Sums(6, 12),
                new Sums(15, 15),
                new Sums(24, 18)};

        assertThat(RolColSum.sum(array)).isEqualTo(expected);
    }

    @Test
    void asyncSum() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Sums[] expected = new Sums[]{new Sums(6, 12),
                new Sums(15, 15),
                new Sums(24, 18)};

        assertThat(RolColSum.asyncSum(array)).isEqualTo(expected);
    }
}