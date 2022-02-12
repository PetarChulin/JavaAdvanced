package JavaAdvancedExam;

import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        int turns = Integer.parseInt(s.nextLine());
        char[][] matrix = new char[n][n];

        fillMatrix(s, n, matrix);

        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        while (turns-- > 0) {

            String input = s.nextLine();
            matrix[playerRow][playerCol] = '.';
            switch (input) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            playerCol = checkBounds(n, playerCol);
            playerRow = checkBounds(n, playerRow);

            if (matrix[playerRow][playerCol] == 'B') {
                switch (input) {
                    case "up":
                        playerRow--;
                        break;
                    case "down":
                        playerRow++;
                        break;
                    case "left":
                        playerCol--;
                        break;
                    case "right":
                        playerCol++;
                        break;
                }
            } else if (matrix[playerRow][playerCol] == 'T') {
                switch (input) {
                    case "up":
                        playerRow++;
                        break;
                    case "down":
                        playerRow--;
                        break;
                    case "left":
                        playerCol++;
                        break;
                    case "right":
                        playerCol--;
                        break;
                }
            }

            playerCol = checkBounds(n, playerCol);
            playerRow = checkBounds(n, playerRow);

            if (matrix[playerRow][playerCol] == 'F') {
                matrix[playerRow][playerCol] = 'P';
                System.out.println("Well done, the player won first place!");
                break;
            }
            matrix[playerRow][playerCol] = 'P';
            if (turns == 0) {
                System.out.println("Oh no, the player got lost on the track!");
            }
        }
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }


    private static void fillMatrix(Scanner s, int n, char[][] matrix) {
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            char[] symbol = line.toCharArray();
            matrix[i] = symbol;
        }
    }

    private static int checkBounds(int n, int playerCol) {
        if (playerCol < 0) {
            playerCol = n - 1;
        } else if (playerCol > n - 1) {
            playerCol = 0;
        }
        return playerCol;
    }
}
