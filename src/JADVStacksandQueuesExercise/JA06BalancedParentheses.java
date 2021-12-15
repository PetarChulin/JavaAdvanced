package JADVStacksandQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class JA06BalancedParentheses {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        if (isBalanced(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isBalanced(String input) {
        ArrayDeque<Character> sequence = new ArrayDeque<>();
        for (char symbol : input.toCharArray()) {

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                sequence.addFirst(symbol);
            } else {
                if (!sequence.isEmpty() && ((sequence.peekFirst() == '{' && symbol == '}')
                        || (sequence.peekFirst() == '[' && symbol == ']')
                        || (sequence.peekFirst() == '(' && symbol == ')'))) {
                    sequence.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
