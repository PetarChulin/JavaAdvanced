package JavaAdvancedExam19August2020;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.System.in;

public class P01FlowerWreaths {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        List<Integer> line1 = getCollect(s);
        List<Integer> line2 = getCollect(s);
        Collections.reverse(line1);

        int wreaths = 0;
        int restFlowers = 0;

        ArrayDeque<Integer> lilies = new ArrayDeque<>(line1);
        ArrayDeque<Integer> roses = new ArrayDeque<>(line2);

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int sum = lilies.peek() + roses.peek();

            if (sum == 15) {
                wreaths++;
            } else if (sum > 15) {
                int temp = lilies.peek();
                while (sum > 15) {
                    temp -= 2;
                    sum = temp + roses.peek();
                }
                if (sum == 15) {
                    wreaths++;
                } else {
                    restFlowers += sum;
                }
            } else {
                restFlowers += sum;
            }
            lilies.pop();
            roses.poll();
        }
        if ((restFlowers / 15) >= 1) {
            wreaths += restFlowers / 15;
        }
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }

    private static List<Integer> getCollect(Scanner s) {
        return Arrays.stream(s.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
