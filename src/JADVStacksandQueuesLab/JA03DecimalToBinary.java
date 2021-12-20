package JADVStacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class JA03DecimalToBinary {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();

        ArrayDeque<Integer> digit = new ArrayDeque<>();

        int decimal = Integer.parseInt(input);
        if (decimal == 0) {
            System.out.println(0);
        }
        while (decimal > 0) {
            digit.push(decimal % 2);
            decimal = decimal / 2;
        }
        while (!digit.isEmpty()) {
            System.out.print(digit.pop());
        }
    }
}
