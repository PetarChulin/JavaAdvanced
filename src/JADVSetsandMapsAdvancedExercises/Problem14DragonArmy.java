package JADVSetsandMapsAdvancedExercises;

import java.util.*;

public class Problem14DragonArmy {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Map<String, Map<String, List<Integer>>> dragonType = new LinkedHashMap<>();
        Map<String, List<Integer>> dragonName = new TreeMap<>();

        int n = Integer.parseInt(s.nextLine());
        int defaultHealth = 250;
        int defaultDamage = 45;
        int defaultArmor = 10;

        for (int i = 0; i < n; i++) {
            String input = s.nextLine();

            List<Integer> values = new ArrayList<>();
            String type = input.split(" ")[0];
            String name = input.split(" ")[1];

            ifNullValue(defaultDamage, input, values, 2);
            ifNullValue(defaultHealth, input, values, 3);
            ifNullValue(defaultArmor, input, values, 4);

            if (!dragonName.containsKey(name)) {
                dragonName.put(name, values);
            } else {
                dragonName.get(name).addAll(values);
            }
            dragonType.putIfAbsent(type, new TreeMap<>());
            dragonType.get(type).put(name, values);
        }
        for (Map.Entry<String, Map<String, List<Integer>>> entry : dragonType.entrySet()) {
            double avgDamage = 0;
            avgDamage = getAverage(entry, avgDamage, 0);

            double avgHealth = 0;
            avgHealth = getAverage(entry, avgHealth, 1);

            double avgArmor = 0;
            avgArmor = getAverage(entry, avgArmor, 2);

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", entry.getKey(), avgDamage, avgHealth, avgArmor);
            for (Map.Entry<String, List<Integer>> dragon : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        dragon.getKey(), dragon.getValue().get(0),
                        dragon.getValue().get(1), dragon.getValue().get(2));
            }
        }
    }

    private static void ifNullValue(int defaultDamage, String input, List<Integer> values, int i2) {
        int damage;
        if (input.split(" ")[i2].equals("null")) {
            damage = defaultDamage;
        } else {
            damage = Integer.parseInt(input.split(" ")[i2]);
        }
        values.add(damage);
    }

    private static double getAverage(Map.Entry<String, Map<String, List<Integer>>> entry, double avgDamage, int i2) {
        for (Map.Entry<String, List<Integer>> aD : entry.getValue().entrySet()) {
            avgDamage += aD.getValue().get(i2);
        }
        avgDamage /= entry.getValue().size();
        return avgDamage;
    }
}

