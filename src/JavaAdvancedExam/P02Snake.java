package JavaAdvancedExam28June2020;

import java.util.Scanner;

import static java.lang.System.in;

public class P02Snake {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        int size = Integer.parseInt(s.nextLine());
        char[][] field = new char[size][size];
        int food = 0;

        for (int i = 0; i < size; i++) {
            field[i] = s.nextLine().toCharArray();
        }
        int snakeRow = 0;
        int snakeCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }
        while (true) {
            String direction = s.nextLine();
            field[snakeRow][snakeCol] = '.';
            switch (direction) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }
            if (snakeRow < 0 || snakeRow > size - 1 || snakeCol < 0 || snakeCol > size - 1) {
                System.out.println("Game over!");
                break;
            }
            if (field[snakeRow][snakeCol] == '*') {
                field[snakeRow][snakeCol] = '.';
                food++;
            }
            if (field[snakeRow][snakeCol] == 'B') {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        while (field[i][j] == 'B') {
                            field[i][j] = '.';
                            snakeRow = i;
                            snakeCol = j;
                        }
                    }
                }
            }
            field[snakeRow][snakeCol] = 'S';
            if (food >= 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
        }
        System.out.printf("Food eaten: %d\n" , food);
        for (char[] chars : field) {
            System.out.println(chars);
        }
    }
}
