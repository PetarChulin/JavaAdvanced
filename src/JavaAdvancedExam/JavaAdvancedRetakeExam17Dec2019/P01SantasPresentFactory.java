package JavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01SantasPresentFactory {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();

        String[] line1 = s.nextLine().split(" ");
        String[] line2 = s.nextLine().split(" ");
        Map<String, Integer> presents = new TreeMap<>();

        for (String e : line1) {
            materials.push(Integer.parseInt(e));
        }
        for (String e : line2) {
            magicLevel.offer(Integer.parseInt(e));
        }

        int dollCount = 0;
        int trainCount = 0;
        int bearCount = 0;
        int bicycleCount = 0;

        while (!materials.isEmpty() && !magicLevel.isEmpty()) {

            if (materials.peek() == 0 || magicLevel.peek() == 0) {
                if (materials.peek() == 0) {
                    materials.pop();
                }
                if (magicLevel.peek() == 0) {
                    magicLevel.poll();
                }
                continue;
            }
            int value = materials.peek() * magicLevel.peek();

            if (value == 150) {
                String type = "Doll";
                dollCount++;
                makeToy(presents, type);
            } else if (value == 250) {
                String type = "Wooden train";
                trainCount++;
                makeToy(presents, type);
            } else if (value == 300) {
                String type = "Teddy bear";
                bearCount++;
                makeToy(presents, type);
            } else if (value == 400) {
                String type = "Bicycle";
                bicycleCount++;
                makeToy(presents, type);
            } else if (value < 0) {
                int temp = materials.peek() + magicLevel.peek();
                materials.pop();
                magicLevel.poll();
                materials.push(temp);
                continue;
            } else if (value > 0) {
                magicLevel.poll();
                int temp = materials.pop() + 15;
                materials.push(temp);
                continue;
            }
            materials.pop();
            magicLevel.poll();
        }
        if ((dollCount >= 1 && trainCount >= 1) || (bearCount >= 1 && bicycleCount >= 1)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(materials.toString().replaceAll("[\\[\\]]", ""));
        }
        if (!magicLevel.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magicLevel.toString().replaceAll("[\\[\\]]", ""));
        }

        presents.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }

    private static void makeToy(Map<String, Integer> presents, String type) {
        presents.putIfAbsent(type, 0);
        presents.put(type, presents.get(type) + 1);
    }
}
