package JADVStacksandQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class JA01ReverseNumberswithaStack {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] n = s.nextLine().split(" ");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (String value : n) {

            numbers.push(Integer.parseInt(value));
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
