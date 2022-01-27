package JavaAdvancedExam;

import java.util.Scanner;

import static java.lang.System.in;

public class P02Cookingjourney {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        int n = Integer.parseInt(s.nextLine());
        char[][] pastry = new char[n][n];

        for (int i = 0; i < n; i++) {
            pastry[i] = s.nextLine().toCharArray();
        }
        int sRow = 0;
        int sCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pastry[i][j] == 'S') {
                    sRow = i;
                    sCol = j;
                }
            }
        }
        int money = 0;
        while (true) {
            String direction = s.nextLine();
            pastry[sRow][sCol] = '-';

            switch (direction) {
                case "up":
                    sRow--;
                    break;
                case "down":
                    sRow++;
                    break;
                case "left":
                    sCol--;
                    break;
                case "right":
                    sCol++;
                    break;
            }
            if (sRow  < 0 || sRow  > n - 1 || sCol  < 0 || sCol  > n - 1) {
                break;
            }
            int digit = pastry[sRow][sCol];
            if (Character.isDigit(digit)) {
                money += Integer.parseInt(Character.toString((char) digit));
            }
            boolean isPillar = pastry[sRow][sCol] == 'P';
            if (isPillar) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        while (pastry[i][j] == 'P') {
                            pastry[i][j] = '-';
                            sRow = i;
                            sCol = j;
                        }
                    }
                }
            }
            pastry[sRow][sCol] = 'S';
            if (money >= 50) {
                break;
            }
        }
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.printf("Money: %d\n", money);
        for (char[] chars : pastry) {
            System.out.println(chars);
        }
    }
}
