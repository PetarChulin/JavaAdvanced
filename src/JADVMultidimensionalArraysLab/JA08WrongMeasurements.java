package JADVMultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class JA08WrongMeasurements {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());

        String[] rows = s.nextLine().split(" ");

        int[][] finalMat = new int[n][rows.length];
        int[][] matrix = new int[n][rows.length];

        rows = fillMatrix(s, n, rows, matrix);
        int row = Integer.parseInt(rows[0]);
        int col = Integer.parseInt(rows[1]);
        int sum = 0;

        int  digitToReplace = Integer.parseInt(String.valueOf(matrix[row][col]));

        sumAndReplace(matrix, finalMat, sum, digitToReplace);
        for (int[] ints : finalMat) {
            System.out.println(Arrays.toString(ints)
                    .replaceAll("[\\[\\],]", ""));

        }
    }

    private static String[] fillMatrix(Scanner s, int n, String[] rows, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(rows[j]);
            }
            rows = s.nextLine().split(" ");
        }
        return rows;
    }

    private static void sumAndReplace(int[][] matrix, int[][] finalMat, int sum, int digitToReplace) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == digitToReplace) {

                    if (i > 0 && matrix[i - 1][j] != digitToReplace) {
                        sum += matrix[i - 1][j];
                    }
                    if (j > 0 && matrix[i][j - 1] != digitToReplace) {
                        sum += matrix[i][j - 1];
                    }
                    if (j < matrix[i].length - 1 && matrix[i][j + 1] != digitToReplace) {
                        sum += matrix[i][j + 1];
                    }
                    if (i < matrix.length - 1 && matrix[i + 1][j] != digitToReplace) {
                        sum += matrix[i + 1][j];
                    }
                    finalMat[i][j] = Integer.parseInt(String.valueOf(sum));
                    sum = 0;
                } else {
                    finalMat[i][j] = matrix[i][j];
                }
            }
        }
    }
}
