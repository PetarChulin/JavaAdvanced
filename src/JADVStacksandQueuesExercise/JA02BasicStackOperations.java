package JADVStacksandQueuesExercise;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Scanner;

public class JA02BasicStackOperations {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] numbers = s.nextLine().split(" ");
        String[] input = s.nextLine().split("\\s+");

        ArrayDeque<Integer> line = new ArrayDeque<>();

        int N = Integer.parseInt(numbers[0]);
        int S = Integer.parseInt(numbers[1]);
        int X = Integer.parseInt(numbers[2]);

        for (int i = 0; i < N; i++) {

            line.push(Integer.parseInt(input[i]));
        }
        for (int i = 0; i < S; i++) {

            line.pop();
        }
        if (line.contains(X)) {
            System.out.println("true");
        } else {
            Optional<Integer> minElement = line.stream().min(Integer::compareTo);
            System.out.println(minElement.orElse(0));
        }
    }
}
