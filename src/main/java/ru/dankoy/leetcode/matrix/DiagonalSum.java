package ru.dankoy.leetcode.matrix;

/**
 * 1572. Matrix Diagonal Sum
 * Solved
 * Easy
 * 
 * Given a square matrix mat, return the sum of the matrix diagonals.
 * 
 * Only include the sum of all the elements on the primary diagonal and all the
 * elements on the secondary diagonal that are not part of the primary diagonal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * Output: 25
 * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 * Notice that element mat[1][1] = 5 is counted only once.
 * 
 * Example 2:
 * 
 * Input: mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * Output: 8
 * 
 * Example 3:
 * 
 * Input: mat = [[5]]
 * Output: 5
 * 
 * 
 * 
 * Constraints:
 * 
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 * 
 * 
 */
public class DiagonalSum {

    public static void main(String[] args) {

        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix = { { 5 } };

        var sum = diagonalSum(matrix);

        System.out.println(sum);

    }

    private static int diagonalSum(int[][] matrix) {

        int sum = 0;

        int i = 0;
        int j = 0;

        while (i < matrix.length && j < matrix.length) {

            sum = sum + matrix[i][j];
            sum = sum + matrix[i][matrix.length - i - 1];

            i++;
            j++;

        }

        if (matrix.length % 2 == 1) { // если размерность матрицы нечетная, вычитаем серединный элемент один раз,
                                      // чтобы избежать двойного подсчета
            sum -= matrix[matrix.length / 2][matrix.length / 2];
        }

        return sum;

    }

}
