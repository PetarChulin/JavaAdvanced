package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class P02Cooking {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        List<Integer> line1 = getCollect(s);
        List<Integer> line2 = getCollect(s);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (Integer item : line1) {
            liquids.offer(item);
        }
        for (Integer item : line2) {
            ingredients.push(item);
        }
        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Bread", 0);
        foods.put("Cake", 0);
        foods.put("Fruit Pie", 0);
        foods.put("Pastry", 0);


//        int countBread = 0;
//        int countCake = 0;
//        int countPastry = 0;
//        int countFruitPie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int sum = liquids.peek() + ingredients.peek();

            if (sum == 25) {
                String type = "Bread";
                foods.put(type, foods.get(type) + 1);
//                countBread++;
            } else if (sum == 50) {
                String type = "Cake";
                foods.put(type, foods.get(type) + 1);
//                countCake++;
            } else if (sum == 75) {
                String type = "Pastry";
                foods.put(type, foods.get(type) + 1);
//                countPastry++;
            } else if (sum == 100) {
                String type = "Fruit Pie";
                foods.put(type, foods.get(type) + 1);
//                countFruitPie++;
            } else {
                liquids.poll();
                int temp = ingredients.pop() + 3;
                ingredients.offerFirst(temp);
                continue;
            }
            liquids.poll();
            ingredients.pop();
        }
        if (foods.get("Bread") >= 1 && foods.get("Cake") >= 1 && foods.get("Pastry") >= 1 && foods.get("Fruit Pie") >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (!liquids.isEmpty()) {
            System.out.println(liquids.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("none");

        }
        System.out.print("Ingredients left: ");
        if (!ingredients.isEmpty()) {
            String output = ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(output);
        } else {
            System.out.println("none");
        }
        foods.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }

    private static List<Integer> getCollect(Scanner s) {
        return Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}