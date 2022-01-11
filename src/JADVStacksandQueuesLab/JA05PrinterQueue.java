package JADVStacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class JA05PrinterQueue {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();

        ArrayDeque<String> lines = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                if (lines.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + lines.pollFirst());
                }
            } else {
                lines.offer(input);
            }
            input = s.nextLine();
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }
}

