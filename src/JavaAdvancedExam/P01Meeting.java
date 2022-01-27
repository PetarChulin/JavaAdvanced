package JavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);


        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();

        String[] malesLine = s.nextLine().split(" ");
        String[] femalesLine = s.nextLine().split(" ");

        for (String value : malesLine) {
            males.push(Integer.parseInt(value));
        }
        for (String value : femalesLine) {
            females.offer(Integer.parseInt(value));
        }
        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {

            if (males.peek() <= 0) {
                males.pop();
            } else if (females.peek() <= 0) {
                females.poll();
            } else if (males.peek() % 25 == 0) {
                males.pop();
                males.pop();
            } else if (females.peek() % 25 == 0) {
                females.poll();
                females.poll();
            } else if (males.peek().equals(females.peek())) {
                males.pop();
                females.poll();
                matches++;
            } else {
                females.poll();
                int decreased = Integer.parseInt(String.valueOf(males.pop() - 2));
                males.push(decreased);
            }
        }
        System.out.printf("Matches: %d\n", matches);
        System.out.print("Males left: ");
        if (!males.isEmpty()) {
            System.out.println(String.join(", ", males.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("none");
        }
        System.out.print("Females left: ");
        if (!females.isEmpty()) {
            System.out.print(String.join(", ", females.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.print("none");
        }
    }
}
