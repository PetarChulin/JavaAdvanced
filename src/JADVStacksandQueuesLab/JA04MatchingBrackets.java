package JADVStacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class JA04MatchingBrackets {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String text = s.nextLine();

        ArrayDeque<Integer> brackets = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.toCharArray()[i];

            if (symbol == '(') {
                brackets.push(i);
            } else if (symbol == ')') {
                int startInd = brackets.pop();
                String result = text.substring(startInd, i + 1);
                System.out.println(result);
            }
        }
    }
}
