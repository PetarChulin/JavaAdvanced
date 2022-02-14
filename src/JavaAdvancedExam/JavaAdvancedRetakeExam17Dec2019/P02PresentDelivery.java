package JavaAdvancedExam;

import java.util.Scanner;

import static java.lang.System.in;

public class P02PresentDelivery {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        int presents = Integer.parseInt(s.nextLine());
        int size = Integer.parseInt(s.nextLine());
        char[][] neighborhood = new char[size][size];

        int niceKids = 0;
        int giftedKids = 0;

        chekNeighborhood(s, size, neighborhood);
        niceKids = getNiceKids(size, neighborhood, niceKids);

        int countOfNiceKid = niceKids;

        int santasRow = 0;
        int santasCol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (neighborhood[i][j] == 'S') {
                    santasRow = i;
                    santasCol = j;
                    break;
                }
            }
        }
        while (true) {
            String command = s.nextLine();
            if (command.equals("Christmas morning")) {
                break;
            }
            neighborhood[santasRow][santasCol] = '-';
            switch (command) {

                case "up":
                    santasRow--;
                    break;
                case "down":
                    santasRow++;
                    break;
                case "left":
                    santasCol--;
                    break;
                case "right":
                    santasCol++;
                    break;
            }
            if (santasRow < 0 || santasRow > size - 1 || santasCol < 0 || santasCol > size - 1) {
                break;

            }
            if (neighborhood[santasRow][santasCol] == 'V') {
                neighborhood[santasRow][santasCol] = '-';
                presents--;
                giftedKids++;
                niceKids--;

            } else if (neighborhood[santasRow][santasCol] == 'X') {
                neighborhood[santasRow][santasCol] = '-';

            } else if (neighborhood[santasRow][santasCol] == 'C') {

                char[] cells = new char[4];
                char up = neighborhood[santasRow - 1][santasCol];
                char down = neighborhood[santasRow + 1][santasCol];
                char left = neighborhood[santasRow][santasCol - 1];
                char right = neighborhood[santasRow][santasCol + 1];


                cells[0] = up;
                cells[1] = down;
                cells[2] = left;
                cells[3] = right;

                for (char cell : cells) {
                    if ((cell == 'V') || (cell == 'X')) {
                        if (cell == 'V') {
                            niceKids--;
                        }
                        giftedKids++;
                        presents--;

                        if (presents <= 0) {
                            break;
                        }
                    }
                }
                neighborhood[santasRow - 1][santasCol] = '-';
                neighborhood[santasRow + 1][santasCol] = '-';
                neighborhood[santasRow][santasCol - 1] = '-';
                neighborhood[santasRow][santasCol + 1] = '-';
            }
            neighborhood[santasRow][santasCol] = 'S';

            if (presents == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }
        }
        for (char[] chars : neighborhood) {
            for (char a : chars) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        if (niceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", giftedKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", countOfNiceKid - giftedKids);
        }
    }

    private static void chekNeighborhood(Scanner s, int size, char[][] neighborhood) {
        for (int i = 0; i < size; i++) {
            String[] input = s.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                neighborhood[i][j] = input[j].charAt(0);
            }
        }
    }

    private static int getNiceKids(int size, char[][] neighborhood, int niceKids) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (neighborhood[i][j] == 'V') {
                    niceKids++;
                }
            }
        }
        return niceKids;
    }
}
