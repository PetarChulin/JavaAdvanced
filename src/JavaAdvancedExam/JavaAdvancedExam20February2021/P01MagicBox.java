package JavaAdvancedExam20February2021;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.System.in;

public class P01MagicBox {

    public static void main(String[] args) {
        Scanner s = new Scanner(in);


        ArrayDeque<Integer> magicBoxOne = new ArrayDeque<>();
        ArrayDeque<Integer> magicBoxTwo = new ArrayDeque<>();

        String[] inputOne = s.nextLine().split(" ");
        String[] inputTwo = s.nextLine().split(" ");

        for (String value : inputOne) {
            magicBoxOne.offer(Integer.valueOf(value));
        }
        for (String value : inputTwo) {
            magicBoxTwo.push(Integer.valueOf(value));
        }
        int claimed = 0;
        while (!magicBoxOne.isEmpty() && !magicBoxTwo.isEmpty()) {

            int sum = magicBoxOne.peek() + magicBoxTwo.peek();
            if (sum % 2 == 0) {
                claimed += sum;
                magicBoxOne.poll();
                magicBoxTwo.pop();
            } else {
                magicBoxOne.offerLast(magicBoxTwo.pop());
            }
            if (magicBoxOne.isEmpty()) {
                System.out.println("First magic box is empty.");
                break;
            }
            if (magicBoxTwo.isEmpty()) {
                System.out.println("Second magic box is empty.");
                break;
            }
        }
        if (claimed >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d" , claimed);
        } else {
            System.out.printf("Poor prey... Value: %d" , claimed);
        }
    }
}
