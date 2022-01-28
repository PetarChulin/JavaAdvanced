package JavaAdvancedExam28June2020;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class P01Bombs {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        List<Integer> line1 = getCollect(s);
        List<Integer> line2 = getCollect(s);
        Collections.reverse(line2);


        ArrayDeque<Integer> effect = new ArrayDeque<>(line1);
        ArrayDeque<Integer> casing = new ArrayDeque<>(line2);
        Map<String, Integer> bombType = getBombType();

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;

        while (!effect.isEmpty() && !casing.isEmpty()) {

            int value = effect.peek() + casing.peek();

            if (value == 40) {
                String type = "Datura Bombs";
                daturaBombs++;
                bombType.put(type, bombType.get(type) + 1);
            } else if (value == 60) {
                String type = "Cherry Bombs";
                cherryBombs++;
                bombType.put(type, bombType.get(type) + 1);
            } else if (value == 120) {
                String type = "Smoke Decoy Bombs";
                smokeDecoyBombs++;
                bombType.put(type, bombType.get(type) + 1);
            } else {
                int temp = casing.poll() - 5;
                casing.offerFirst(temp);
                continue;
            }
            effect.pop();
            casing.poll();
            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                break;
            }
        }
        if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.println(effect.toString()
                    .replaceAll("[\\[\\]]", ""));
        }
        if (casing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.println(casing.toString()
                    .replaceAll("[\\[\\]]", ""));
        }
        bombType.forEach((key, value) -> System.out.printf("%s: %d\n" , key , value));
    }

    private static Map<String, Integer> getBombType() {
        Map<String, Integer> bombType = new TreeMap<>();
        bombType.put("Datura Bombs" , 0);
        bombType.put("Cherry Bombs" , 0);
        bombType.put("Smoke Decoy Bombs" , 0);
        return bombType;
    }

    private static List<Integer> getCollect(Scanner s) {
        return Arrays.stream(s.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
