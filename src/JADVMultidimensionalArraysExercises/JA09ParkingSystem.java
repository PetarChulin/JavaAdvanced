package JADVMultidimensionalArraysExercises;

import java.util.Scanner;

public class JA09ParkingSystem {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int cols = s.nextInt();
        s.nextLine();
        boolean[][] parkingLot = fillMatrix(rows, cols);

        while (true) {
            String parkingSpot = s.nextLine();
            if (parkingSpot.equals("stop")) {
                break;
            }
            int entryRow = Integer.parseInt(parkingSpot.split(" ")[0]);
            int spotRow = Integer.parseInt(parkingSpot.split(" ")[1]);
            int spotCol = Integer.parseInt(parkingSpot.split(" ")[2]);

            int cells = Math.abs(entryRow - spotRow) + 1;
            int leftSpot = getLeftSpot(spotCol);
            int rightSpot = getRightSpot(parkingLot, spotCol);

            while (parkingLot[spotRow][leftSpot]) {
                if (leftSpot == 0) {
                    break;
                }
                leftSpot--;
            }
            while (parkingLot[spotRow][rightSpot]) {
                if (rightSpot == parkingLot[0].length - 1) {
                    break;
                }
                rightSpot++;
            }
            if (fullRow(parkingLot, spotRow)) {
                System.out.printf("Row %d full\n", spotRow);
                continue;
            }

            if (!parkingLot[spotRow][spotCol]) {
                parkingLot[spotRow][spotCol] = true;
                cells += spotCol;
                System.out.println(cells);
                continue;
            } else {
                if ((spotCol - leftSpot) > Math.abs(rightSpot - spotCol)) {
                    spotCol = rightSpot;
                } else {
                    spotCol = leftSpot;
                }
            }
            if (parkingLot[spotRow][spotCol] && spotCol <= 1) {
                spotCol = rightSpot;
            }
            if (parkingLot[spotRow][spotCol] &&
                    (spotCol - (spotCol - 1) == Math.abs(spotCol - (spotCol + 1)))) {
                spotCol = leftSpot;
            }
            parkingLot[spotRow][spotCol] = true;
            cells += spotCol;

            System.out.println(cells);

        }
    }

    private static int getRightSpot(boolean[][] parkingLot, int spotCol) {
        int rightSpot;
        if (spotCol + 1 >= parkingLot[0].length - 1) {
            rightSpot = spotCol;
        } else {
            rightSpot = spotCol + 1;
        }
        return rightSpot;
    }

    private static int getLeftSpot(int spotCol) {
        int leftSpot;
        if (spotCol - 1 <= 0) {
            leftSpot = 1;
        } else {
            leftSpot = spotCol - 1;
        }
        return leftSpot;
    }

    private static boolean fullRow(boolean[][] parkingLot, int spotRow) {
        for (int i = 1; i < parkingLot[spotRow].length; i++) {
            if (!parkingLot[spotRow][i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean[][] fillMatrix(int rows, int cols) {
        boolean[][] parkingLot = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                parkingLot[i][0] = true;
            }
        }
        return parkingLot;
    }

}



