package JavaAdvancedRetakeExam16December2020;

import java.util.Scanner;

import static java.lang.System.in;

public class P02Selling {

    public static void main(String[] args) {
        Scanner s = new Scanner(in);

        int size = Integer.parseInt(s.nextLine());
        char[][] bakery = new char[size][size];


        for (int i = 0; i < size; i++) {
            bakery[i] = s.nextLine().toCharArray();
        }
        int cookRow = 0;
        int cookCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (bakery[i][j] == 'S') {
                    cookRow = i;
                    cookCol = j;
                }
            }
        }
        int money = 0;
        while (true) {
            String command = s.nextLine();
            bakery[cookRow][cookCol] = '-';
            switch (command) {
                case "up":
                    cookRow--;
                    break;
                case "down":
                    cookRow++;
                    break;
                case "left":
                    cookCol--;
                    break;
                case "right":
                    cookCol++;
                    break;
            }
            if (cookRow  < 0 || cookRow  > size - 1 || cookCol  < 0 || cookCol  > size - 1) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
            int digit = bakery[cookRow][cookCol];
            if (Character.isDigit(digit)) {
                money += Integer.parseInt(Character.toString((char) digit));
            }
            boolean isPillar = bakery[cookRow][cookCol] == 'O';
            if (isPillar) {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        while (bakery[i][j] == 'O') {
                            bakery[i][j] = '-';
                            cookRow = i;
                            cookCol = j;
                        }
                    }
                }
            }
            bakery[cookRow][cookCol] = 'S';
            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }
        System.out.printf("Money: %d\n" , money);
        for (char[] chars : bakery) {
            System.out.println(chars);
        }
    }
}
