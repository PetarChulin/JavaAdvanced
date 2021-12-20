package JADVStacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class JA06HotPotato {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" ");
        ArrayDeque<String> kids = new ArrayDeque<>(Arrays.asList(input));

        int n = Integer.parseInt(s.nextLine());

        for (int i = 1; i <= n; i++) {
            if (kids.size() == 1) {
                System.out.println("Last is " + kids.poll());
                break;
            }
            String current = kids.peek();
            if (i % n == 0) {
                System.out.println("Removed " + kids.poll());
                i = 0;
            } else {
                kids.pollFirst();
                kids.offer(current);
            }
        }
    }
}



