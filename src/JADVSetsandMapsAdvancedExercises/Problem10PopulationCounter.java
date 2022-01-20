package JADVSetsandMapsAdvancedExercises;

import java.util.*;


public class Problem10PopulationCounter {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();
        LinkedHashMap<String, Map<String, Long>> report = new LinkedHashMap<>();

        while (!input.equals("report")) {

            String town = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Integer.parseInt(input.split("\\|")[2]);

            report.putIfAbsent(country, new LinkedHashMap<>());
            report.get(country).putIfAbsent(town, population);

            input = s.nextLine();
        }
        report.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue()
                        .values()
                        .stream()
                        .mapToLong(Long::longValue)
                        .sum(),
                e1.getValue()
                        .values()
                        .stream()
                        .mapToLong(Long::longValue)
                        .sum())).forEach(country -> {
            long total = country.getValue().values().stream().mapToLong(Long::longValue).sum();
            System.out.printf("%s (total population: %d)\n", country.getKey(), total);
            country.getValue().entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> System.out.printf("=>%s: %d\n", e.getKey(), e.getValue()));
        });
    }
}



