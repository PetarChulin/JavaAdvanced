package JADVMultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class JA04SumMatrixElements {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] dimensions = s.nextLine().split(",\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][columns];
        int sumElements = 0;

        for (int i = 0; i < rows; i++) {

            String[] elements = s.nextLine().split(",\\s+");
            for (int j = 0; j < columns; j++) {

                matrix[i][j] = Integer.parseInt(elements[j]);
                sumElements += Integer.parseInt(elements[j]);
//                sumElements += matrix[i][j];      //sum variant 2
            }
        }
//        int sum = Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum(); //sum variant 3
//        System.out.printf("%d\n%d\n%d", rows, columns, sum);
        System.out.printf("%d\n%d\n%d", rows, columns, sumElements);
    }
}

