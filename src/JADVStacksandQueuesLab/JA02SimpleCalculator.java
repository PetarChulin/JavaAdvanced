package JADVStacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class JA02SimpleCalculator {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split("\\s+");

        ArrayDeque<String> digits = new ArrayDeque<>(Arrays.asList(input));
        while (digits.size() > 1) {

            int leftDigit = Integer.parseInt(digits.pop());
            String operator = digits.pop();
            int rightDigit = Integer.parseInt(digits.pop());

            int result = 0;

            if (operator.equals("-")) {
                result = leftDigit - rightDigit;
            } else {
                result = leftDigit + rightDigit;
            }
            digits.push(String.valueOf(result));
        }
        System.out.println(digits.peek());
    }
}
