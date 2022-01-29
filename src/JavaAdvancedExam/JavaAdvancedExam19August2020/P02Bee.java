package JavaAdvancedRetakeExam19August2020;
import java.util.Scanner;
import static java.lang.System.in;

public class P02Bee {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        int size = Integer.parseInt(s.nextLine());
        char[][] territory = new char[size][size];

        for (int i = 0; i < size; i++) {
            territory[i] = s.nextLine().toCharArray();
        }
        int beeRow = 0;
        int beeCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (territory[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }
        int pollinated = 0;
        while (true) {
            String direction = s.nextLine();
            if (direction.equals("End")) {
                break;
            }
            territory[beeRow][beeCol] = '.';
            switch (direction) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }
            if (beeRow < 0 || beeRow > size - 1 || beeCol < 0 || beeCol > size - 1) {
                System.out.println("The bee got lost!");
                break;
            }
            if (territory[beeRow][beeCol] == 'O') {
                territory[beeRow][beeCol] = '.';
                switch (direction) {
                    case "up":
                        beeRow--;
                        break;
                    case "down":
                        beeRow++;
                        break;
                    case "left":
                        beeCol--;
                        break;
                    case "right":
                        beeCol++;
                        break;
                }
            }
            if (territory[beeRow][beeCol] == 'f') {
                pollinated++;
                territory[beeRow][beeCol] = '.';
            }
            territory[beeRow][beeCol] = 'B';
        }
            if (pollinated >= 5) {
                System.out.printf("Great job, the bee manage to pollinate %d flowers!\n" , pollinated);
            } else {
                System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n" , 5 - pollinated);
            }
        for (char[] chars : territory) {
            System.out.println(chars);
        }
    }
}
