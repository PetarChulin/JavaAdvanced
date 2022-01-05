package JADVMultidimensionalArraysExercises;

import java.util.Scanner;

public class JA08TheHeiganDance {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int playerPoints = 18500;
        int beginRow = 7;
        int beginCol = 7;
        double heiganPoints = 3000000;
        boolean cloudIsActive = false;

        double damageHeigan = Double.parseDouble(s.nextLine());
        String currentSpell = "";

        while (playerPoints > 0 && heiganPoints > 0) {
            String command = s.nextLine();
            heiganPoints -= damageHeigan;
            if (cloudIsActive) {
                playerPoints -= 3500;
                cloudIsActive = false;

                if (playerPoints < 0) {
                    break;
                }
            }
            if (heiganPoints < 0) {
                break;
            }
            String spell = command.split(" ")[0];
            int row = Integer.parseInt(command.split(" ")[1]);
            int col = Integer.parseInt(command.split(" ")[2]);

            int[][] matrix = hitMatrix(row, col);

            if (matrix[beginRow][beginCol] == 1) {
                if (isValidRow(beginRow - 1, matrix) && matrix[beginRow - 1][beginCol] != 1) {
                    beginRow--;
                } else if (isValidCol(beginCol + 1, matrix) && matrix[beginRow][beginCol + 1] != 1) {
                    beginCol++;
                } else if (isValidRow(beginRow + 1, matrix) && matrix[beginRow + 1][beginCol] != 1) {
                    beginRow++;
                } else if (isValidCol(beginCol - 1, matrix) && matrix[beginRow][beginCol - 1] != 1) {
                    beginCol--;
                }
            }
            if (matrix[beginRow][beginCol] == 1) {
                if (spell.equals("Cloud")) {
                    playerPoints -= 3500;
                    cloudIsActive = true;
                    currentSpell = "Plague Cloud";
                } else if (spell.equals("Eruption")) {
                    playerPoints -= 6000;
                    currentSpell = spell;
                }
            }
        }
        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganPoints);
        }
        if (playerPoints <= 0) {
            System.out.printf("Player: Killed by %s\n", currentSpell);
        } else {
            System.out.printf("Player: %d\n", playerPoints);
        }
        System.out.printf("Final position: %d, %d", beginRow, beginCol);
    }

    private static int[][] hitMatrix(int row, int col) {
        int[][] matrix = new int[15][15];
        for (int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < matrix.length) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (j >= 0 && j < matrix[row].length) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }
        return matrix;
    }

    private static boolean isValidRow(int beginRow, int[][] matrix) {
        return beginRow >= 0 && beginRow < matrix[beginRow].length;
    }

    private static boolean isValidCol(int beginCol, int[][] matrix) {
        return beginCol >= 0 && beginCol < matrix.length;
    }
}
