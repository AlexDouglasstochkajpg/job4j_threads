package ru.job4j.pools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RolColSum {

    public static Sums[] sum(int[][] matrix) {
        Sums[] sums = new Sums[matrix.length];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = new Sums();
            sums[i].setRowSum(row(matrix, i));
            sums[i].setColSum(col(matrix, i));
        }
        return sums;
    }

    public static Sums[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        Map<Integer, CompletableFuture<Sums>> futures = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            futures.put(i, getTask(matrix, i));
        }
        Sums[] sumsRsl = new Sums[matrix.length];
        for (Integer temp : futures.keySet()) {
            sumsRsl[temp] = futures.get(temp).get();
        }
        return sumsRsl;
    }

    public static int col(int[][] array, int index) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][index];
        }
        return sum;
    }

    public static int row(int[][] array, int index) {
        int sum = 0;
        for (int i = 0; i < array[index].length; i++) {
            sum += array[index][i];
        }
        return sum;
    }

    public static CompletableFuture<Sums> getTask(int[][] matrix, int i) {
        return CompletableFuture.supplyAsync(() -> {
            Sums s = new Sums();
            s.setRowSum(row(matrix, i));
            s.setColSum(col(matrix, i));
            return s;
        });
    }
}

