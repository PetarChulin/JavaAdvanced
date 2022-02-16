package JavaAdvancedExam;

import java.util.*;

public class P01Pastryshop {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);


        String[] lineLiquids = s.nextLine().split(" ");
        String[] lineIngredients = s.nextLine().split(" ");

        ArrayDeque<Integer> liquids = new ArrayDeque();
        ArrayDeque<Integer> ingredients = new ArrayDeque();

        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Biscuit", 0);
        foods.put("Cake", 0);
        foods.put("Pie", 0);
        foods.put("Pastry", 0);

        Arrays.stream(lineLiquids).mapToInt(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(lineIngredients).mapToInt(Integer::parseInt).forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int sum = liquids.peek() + ingredients.peek();
            String type;
            if (sum == 25) {
                type = "Biscuit";
                foods.put(type, foods.get(type) + 1);
            } else if (sum == 50) {
                type = "Cake";
                foods.put(type, foods.get(type) + 1);
            } else if (sum == 75) {
                type = "Pastry";
                foods.put(type, foods.get(type) + 1);
            } else if (sum == 100) {
                type = "Pie";
                foods.put(type, foods.get(type) + 1);
            } else {
                liquids.pop();
                int temp = ingredients.pop() + 3;
                ingredients.offerFirst(temp);
                continue;
            }
            liquids.poll();
            ingredients.pop();
        }
        if (foods.get("Biscuit") >= 1 && foods.get("Cake") >= 1 && foods.get("Pastry") >= 1 && foods.get("Pie") >= 1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (!liquids.isEmpty()) {
            System.out.println(String.join(", ", liquids.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("none");
        }
        System.out.print("Ingredients left: ");
        if (!ingredients.isEmpty()) {
            System.out.println(String.join(", ", ingredients.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("none");
        }
        foods.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
