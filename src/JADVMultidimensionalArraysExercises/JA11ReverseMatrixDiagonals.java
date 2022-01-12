package JADVMultidimensionalArraysExercises;

import java.util.Scanner;

public class JA11ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        fillMatrix(sc, rows, cols, matrix);
        getCol(rows, cols, matrix);
        getRow(rows, matrix);
    }

    private static void getRow(int rows, int[][] matrix) {
        int row = rows - 1;
        while (row > 0) {
            int currRow = row - 1;
            int currentCol = 0;
            while (currRow >= 0) {
                if (currentCol >= matrix[currRow].length) {
                    break;
                }
                System.out.print(matrix[currRow][currentCol] + " ");
                currentCol++;
                currRow--;
            }
            System.out.println();
            row--;
        }
    }

    private static void getCol(int rows, int cols, int[][] matrix) {
        int col = cols;
        while (cols > 0) {
            int currCol = cols - 1;
            int currRow = rows - 1;
            while (currCol < col && currRow >= 0) {
                System.out.print(matrix[currRow][currCol] + " ");
                currCol++;
                currRow--;
            }
            System.out.println();
            cols--;
        }
    }


    private static void fillMatrix(Scanner sc, int rows, int cols, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
}
