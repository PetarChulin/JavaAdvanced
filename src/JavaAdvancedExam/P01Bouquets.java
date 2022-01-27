package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bouquets {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        List<Integer> line1 = getCollect(s);
        List<Integer> line2 = getCollect(s);
        Collections.reverse(line1);

        int bouquets = 0;
        int restFlowers = 0;

        ArrayDeque<Integer> tulips = new ArrayDeque<>(line1);
        ArrayDeque<Integer> daffodils = new ArrayDeque<>(line2);

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {

            int sum = tulips.peek() + daffodils.peek();

            if (sum == 15) {
                bouquets++;

            } else if (sum > 15) {
                int temp = tulips.peek();
                while (sum > 15) {
                    temp -= 2;
                    sum = temp + daffodils.peek();
                }
                if (sum == 15) {
                    bouquets++;
                } else {
                    restFlowers += sum;
                }
            } else {
                restFlowers += sum;
            }
            tulips.pop();
            daffodils.poll();
        }
        if ((restFlowers / 15) >= 1) {
            bouquets += restFlowers / 15;
        }
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }

    private static List<Integer> getCollect(Scanner s) {
        return Arrays.stream(s.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
