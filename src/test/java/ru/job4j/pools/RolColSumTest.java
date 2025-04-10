package ru.job4j.pools;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

class RolColSumTest {

    @Test
    void sum() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Sums[] data = RolColSum.sum(array);
        int[][] expected = {
                {6, 12},
                {15, 15},
                {24, 18}
        };
        for (int i = 0; i < array.length; i++) {
            assertEquals(expected[i][0], data[i].getRowSum());
            assertEquals(expected[i][1], data[i].getColSum());
        }
    }

    @Test
    void asyncSum() throws ExecutionException, InterruptedException {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Sums[] data = RolColSum.asyncSum(array);
        int[][] expected = {
                {6, 12},
                {15, 15},
                {24, 18}
        };
        for (int i = 0; i < array.length; i++) {
            assertEquals(expected[i][0], data[i].getRowSum());
            assertEquals(expected[i][1], data[i].getColSum());
        }
    }
}