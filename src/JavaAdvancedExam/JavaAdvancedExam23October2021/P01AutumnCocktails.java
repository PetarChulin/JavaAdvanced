package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class P01AutumnCocktails {
    public static final int Pear_Sour = 150;
    public static final int The_Harvest = 250;
    public static final int Apple_Hinny = 300;
    public static final int High_Fashion = 400;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        List<Integer> line1 = getCollect(s);
        List<Integer> line2 = getCollect(s);
        Collections.reverse(line2);

        Map<String, Integer> cocktails = new TreeMap<>();

        ArrayDeque<Integer> ingredient = new ArrayDeque<>(line1);
        ArrayDeque<Integer> freshness = new ArrayDeque<>(line2);

        int countPS = 0;
        int countTH = 0;
        int countAH = 0;
        int countHF = 0;

        while (!ingredient.isEmpty() && !freshness.isEmpty()) {

            if (ingredient.peek() == 0) {
                ingredient.poll();
                continue;
            }
            int level = ingredient.peek() * freshness.peek();
            String type = "";
            if (level == Pear_Sour) {
                type = "Pear Sour";
                countPS++;
                makeCocktail(cocktails, ingredient, freshness, type);
            } else if (level == The_Harvest) {
                type = "The Harvest";
                countTH++;
                makeCocktail(cocktails, ingredient, freshness, type);
            } else if (level == Apple_Hinny) {
                type = "Apple Hinny";
                countAH++;
                makeCocktail(cocktails, ingredient, freshness, type);
            } else if (level == High_Fashion) {
                type = "High Fashion";
                countHF++;
                makeCocktail(cocktails, ingredient, freshness, type);
            } else {
                freshness.pop();
                int temp = ingredient.poll() + 5;
                ingredient.offer(temp);
            }

        }
        if ((countAH >= 1) && (countHF >= 1) && (countTH >= 1) && (countPS >= 1)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int sum = 0;
        for (Integer integer : ingredient) {
            sum += integer;
        }
        if (!ingredient.isEmpty()) {
            System.out.printf("Ingredients left: %d\n", sum);
        }
        cocktails.forEach((key, value) -> System.out.printf("# %s --> %d\n", key, value));
    }

    private static void makeCocktail(Map<String, Integer> cocktails, ArrayDeque<Integer> ingredient, ArrayDeque<Integer> freshness, String type) {
        cocktails.putIfAbsent(type, 0);
        cocktails.put(type, cocktails.get(type) + 1);
        ingredient.poll();
        freshness.pop();
    }

    private static List<Integer> getCollect(Scanner s) {
        return Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}