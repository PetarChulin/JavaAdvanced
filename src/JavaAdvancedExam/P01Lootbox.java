package JAVAAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class P01Lootbox {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        List<Integer> line1 = getCollect(s);
        List<Integer> line2 = getCollect(s);
        Collections.reverse(line2);

        int claimedItems = 0;

        ArrayDeque<Integer> lootBoxOne = new ArrayDeque<>(line1);
        ArrayDeque<Integer> lootBoxTwo = new ArrayDeque<>(line2);

        while (!lootBoxOne.isEmpty() || !lootBoxTwo.isEmpty()) {

            int sum = lootBoxOne.peek() + lootBoxTwo.peek();

            if (sum % 2 == 0) {
                claimedItems += sum;
                lootBoxOne.pop();
                lootBoxTwo.poll();
            } else {
                lootBoxOne.addLast(lootBoxTwo.poll());
            }

            if (lootBoxOne.isEmpty()) {
                System.out.println("First lootbox is empty");
                break;
            }
            if (lootBoxTwo.isEmpty()) {
                System.out.println("Second lootbox is empty");
                break;
            }
        }
        if (claimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", claimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", claimedItems);
        }
    }

    private static List<Integer> getCollect(Scanner s) {
        return Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
