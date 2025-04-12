package ru.job4j.pools;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RolColSumTest {

    @Test
    void sum() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Sums[] data = RolColSum.sum(array);
        int[][] actual = Arrays.stream(data)
                .map(s -> new int[]{s.getRowSum(), s.getColSum()})
                .toArray(int[][]::new);

        int[][] expected = {
                {6, 12},
                {15, 15},
                {24, 18}
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void asyncSum() throws ExecutionException, InterruptedException {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Sums[] data = RolColSum.asyncSum(array);
        int[][] actual = Arrays.stream(data)
                .map(s -> new int[]{s.getRowSum(), s.getColSum()})
                .toArray(int[][]::new);
        int[][] expected = {
                {6, 12},
                {15, 15},
                {24, 18}
        };
        assertArrayEquals(expected, actual);
    }
}