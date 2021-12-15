package JADVStacksandQueuesExercise;

import java.util.Scanner;

public class JA06BalancedParentheses_StringReplace {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        while (input.contains("()") || input.contains("[]") || input.contains("{}")) {
            input = input.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        if (input.length() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
