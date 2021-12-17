package JADVStacksandQueuesExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class JA08SimpleTextEditor {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int operations = Integer.parseInt(s.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> undoList = new ArrayDeque();
        for (int i = 0; i < operations; i++) {
            String input = s.nextLine();
            String command = input.split(" ")[0];
            switch (command) {
                case "1":
                    undoList.push(text.toString());
                    String letter = input.split(" ")[1];
                    text.append(letter);
                    break;
                case "2":
                    undoList.push(text.toString());
                    int count = Integer.parseInt(input.split(" ")[1]);
                    while (count > 0) {
                        text.deleteCharAt(text.length() - 1);
                        count--;
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = new StringBuilder(undoList.pop());
                    break;
            }
        }
    }
}
