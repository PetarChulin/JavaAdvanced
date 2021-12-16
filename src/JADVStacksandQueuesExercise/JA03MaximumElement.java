package JADVStacksandQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

public class JA03MaximumElement {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());

        ArrayDeque<Integer> sequence = new ArrayDeque();

        for (int i = 0; i < n; i++) {
            String input = s.nextLine();
            String command = input.split(" ")[0];

            switch (command) {
                case "1":
                    int element = Integer.parseInt(input.split(" ")[1]);
                    sequence.push(element);
                    break;
                case "2":
                    sequence.pop();
                    break;
                case "3":
                    if (!sequence.isEmpty()) {
                        System.out.println(Collections.max(sequence));
                    }
// with Optional      Optional<Integer> maxElement = sequence.stream().max(Integer::compareTo);
//                    System.out.println(maxElement.orElse(0));
                    break;
            }
        }
    }
}
