package JADVSetsAndMapAdvancedLab;

import java.util.*;

public class JA07CitiesbyContinentandCountry {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        LinkedHashMap<String, Map<String, List<String>>> list = new LinkedHashMap<>();

        while (n-- > 0) {

            String input = s.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];

            list.putIfAbsent(continent, new LinkedHashMap<>());
            list.get(continent).putIfAbsent(country, new ArrayList<>());
            list.get(continent).get(country).add(city);

        }
        printResult(list);
//        list.forEach((key, value) -> {
//            System.out.println(key + ":");
//            value.forEach((k, v) ->
//                    System.out.printf("%s -> %s%n", k, String.join(", ", v)));
//        });
    }

    private static void printResult(LinkedHashMap<String, Map<String, List<String>>> list) {
        for (Map.Entry<String, Map<String, List<String>>> entry : list.entrySet()) {
            System.out.printf("%s: \n", entry.getKey());
            for (Map.Entry<String, List<String>> country : entry.getValue().entrySet()) {
                System.out.printf("  %s -> ", country.getKey());
                System.out.print(String.join(", ", country.getValue()));
                System.out.println();
            }
        }
    }
}
