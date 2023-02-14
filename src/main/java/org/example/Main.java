package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("this is an algorithm that given an M X N  matrix " +
                "return all numbers that are the maximum value in its row but the minimum in its column");


        /* 2 tests  run to validate my solution */

        int[][] matrix1 = {{5, 16, 25},    //25
                           {9, 11, 18},    //18
                           {15, 17, 20}};   //20
        int[][] matrix2 = {{100, 60, 20, 50},  //100
                           {70, 80, 11, 90},   //90
                           {10, 50, 44, 30}};  //50


        System.out.println(findNumbers(matrix1));
        // Output: [18]

        System.out.println(findNumbers(matrix2));
        // Output: [50]
    }



    public static List<Integer> findNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMaxmum = new int[m];
        int[] colMinmum = new int[n];
        List<Integer> result = new ArrayList<>();

        // store rowMax array with maximum value in each row
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, matrix[i][j]);
            }
            rowMaxmum[i] = max;
        }

        // store colMin array with minimum value in each column
        for (int j = 0; j < n; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                min = Math.min(min, matrix[i][j]);
            }
            colMinmum[j] = min;
        }

        // compare values in matrix with rowMax and colMin to determine min in col
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMaxmum[i] && matrix[i][j] == colMinmum[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}

/*
 *
 * The time complexity of the solution above is O(M * N),
 * where M is the number of rows in the matrix and N is the number of columns.
 * This is because the algorithm needs to loop through each element in the matrix, and it takes O(M * N) time.

 * The space complexity of the solution is O(M + N),
 * where M is the number of rows in the matrix and N is the number of columns.
 * This is because the algorithm uses two arrays, rowMax and colMin, of size M and N respectively to store the maximum value in each row and minimum value in each column.
 *
 */
