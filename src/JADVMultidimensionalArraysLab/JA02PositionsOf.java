package JADVMultidimensionalArraysLab;

import java.util.Scanner;

public class JA02PositionsOf {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

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
        int n = Integer.parseInt(s.nextLine());

        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix[row].length; cols++) {
                if (matrix[row][cols] == n) {
                    System.out.println(row + " " + cols);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
