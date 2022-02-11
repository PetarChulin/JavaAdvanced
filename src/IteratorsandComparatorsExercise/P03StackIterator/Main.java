package IteratorsandComparatorsExercise.P03StackIterator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String input = s.nextLine();
        Stack stack = new Stack();
        while (!input.equals("END")) {
            String command = input.split(" ")[0];
            switch (command) {

                case "Push":
                    String data = input.split("h ")[1];
                    List<String> digits = Arrays.stream(data.split(", "))
                            .collect(Collectors.toList());
                    for (String digit : digits) {
                        stack.push(digit);
                    }
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
            input = s.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (String digit : stack) {
                System.out.println(digit);
            }
        }
    }
}
