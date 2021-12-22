package JADVMultidimensionalArraysLab;

import java.util.Scanner;

public class JA03IntersectionofTwoMatrices {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int rows = Integer.parseInt(s.nextLine());
        int columns = Integer.parseInt(s.nextLine());

        char[][] matrixOne = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            String line = s.nextLine().replaceAll(" ", "");
            char[] c = line.toCharArray();

            if (columns >= 0) System.arraycopy(c, 0, matrixOne[i], 0, columns); //system array copy
//            for (int j = 0; j < columns; j++) {          //with for loop
//                matrixOne[i][j] = c[j];
//            }
        }
        char[][] matrixTwo = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            String line = s.nextLine().replaceAll(" ", "");
            char[] c = line.toCharArray();

            if (columns >= 0) System.arraycopy(c, 0, matrixTwo[i], 0, columns); //system array copy
//            for (int j = 0; j < columns; j++) {         //with for loop
//                matrixTwo[i][j] = c[j];
//            }
        }
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixTwo[i].length; j++) {
                if (matrixOne[i][j] == matrixTwo[i][j]) {
                    System.out.print(matrixOne[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
        System.out.println();
        }
    }
}

