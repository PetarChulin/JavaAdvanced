package JADVMultidimensionalArraysLab;


import java.util.Scanner;

public class JA05MaximumSumof2X2Submatrix {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] dimensions = s.nextLine().split(",\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] elements = s.nextLine().split(",\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }
        int maxSum = 0;
        int biggestRow = 0;
        int biggestCol = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int sumSumMatrix = matrix[i][j] + matrix[i][j + 1]
                        + matrix[i + 1][j] +
                        matrix[i + 1][j + 1];

                if (sumSumMatrix > maxSum) {
                    maxSum = sumSumMatrix;
                    biggestRow = i;
                    biggestCol = j;
                }
            }
        }
        System.out.println(matrix[biggestRow][biggestCol] + " " + matrix[biggestRow][biggestCol + 1]);
        System.out.println(matrix[biggestRow + 1][biggestCol] + " " + matrix[biggestRow + 1][biggestCol + 1]);
        System.out.println(maxSum);
    }
}