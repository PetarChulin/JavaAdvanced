package JADVMultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class JA01CompareMatrices {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int[][] matrixOne = result(s);
        int[][] matrixTwo = result(s);

        if (Arrays.deepEquals(matrixOne, matrixTwo)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }
    private static int[][] result(Scanner s) {
        String[] input = s.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] line = s.nextLine().split("\\s+");

            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }
}
