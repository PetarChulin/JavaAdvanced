package JADVMultidimensionalArraysExercises;


import java.util.Scanner;

public class JA04MaximalSum {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int cols = s.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        int sum = 0;
        int biggestRow = 0;
        int biggestCol = 0;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {

                int sumSubMatrix = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if (sumSubMatrix > sum) {
                    sum = sumSubMatrix;
                    biggestRow = i;
                    biggestCol = j;
                }
            }
        }
        System.out.printf("Sum = %d\n", sum);
        System.out.println(matrix[biggestRow][biggestCol] + " " + matrix[biggestRow][biggestCol + 1] + " " + matrix[biggestRow][biggestCol + 2]);
        System.out.println(matrix[biggestRow + 1][biggestCol] + " " + matrix[biggestRow + 1][biggestCol + 1] + " " + matrix[biggestRow + 1][biggestCol + 2]);
        System.out.println(matrix[biggestRow + 2][biggestCol] + " " + matrix[biggestRow + 2][biggestCol + 1] + " " + matrix[biggestRow + 2][biggestCol + 2]);
    }
}
