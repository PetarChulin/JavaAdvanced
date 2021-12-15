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
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char symbol : input.toCharArray()) {

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                stack.addFirst(symbol);
            } else {
                if (!stack.isEmpty() && ((stack.peekFirst() == '{' && symbol == '}')
                        || (stack.peekFirst() == '[' && symbol == ']')
                        || (stack.peekFirst() == '(' && symbol == ')'))) {
                    stack.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
