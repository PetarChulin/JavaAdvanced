package JavaAdvancedExam;

import java.util.Scanner;

public class P02ThroneConquering {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int energy = Integer.parseInt(s.nextLine());
        int size = Integer.parseInt(s.nextLine());
        char[][] city = new char[size][size];

        fillCity(s, size, city);

        int parisRow = 0;
        int parisCol = 0;
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[i].length; j++) {
                if (city[i][j] == 'P') {
                    parisRow = i;
                    parisCol = j;

                }
            }
        }


        while (true) {
            String lines = s.nextLine();
            String direction = lines.split(" ")[0];
            int spawnRol = Integer.parseInt(lines.split(" ")[1]);
            int spawnCol = Integer.parseInt(lines.split(" ")[2]);

            city[parisRow][parisCol] = '-';
            city[spawnRol][spawnCol] = 'S';
            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < city.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < city.length) {
                        parisCol++;
                    }
                    break;
            }
            energy--;

            if (energy <= 0) {
                city[parisRow][parisCol] = 'X';
                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                printMatrix(city);
                break;
            }
            if (city[parisRow][parisCol] == 'S') {
                energy -= 2;
                if (energy <= 0) {
                    city[parisRow][parisCol] = 'X';
                    System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
                    printMatrix(city);
                    break;
                } else {
                    city[parisRow][parisCol] = '-';
                }
            } else if (city[parisRow][parisCol] == 'H') {
                city[parisRow][parisCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
                printMatrix(city);
                break;
            }

        }
    }


    private static void printMatrix(char[][] city) {
        for (char[] chars : city) {
            System.out.println(chars);
        }
    }

    private static void fillCity(Scanner s, int size, char[][] city) {
        for (int i = 0; i < size; i++) {
            city[i] = s.nextLine().toCharArray();
        }
    }
}

