package JADVSetsandMapsAdvancedExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem13SrybskoUnleashed {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();
        String regex = "(\\w+(?: \\w+)*) @([\\w]+(?: \\w+)*) ([\\d]+) ([\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        Map<String, Map<String, Integer>> listSingers = new LinkedHashMap<>();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {

                String singer = matcher.group(1);
                String place = matcher.group(2);
                int unitPrice = Integer.parseInt(matcher.group(3));
                int tickets = Integer.parseInt(matcher.group(4));

                int totalPrice = tickets * unitPrice;

                fillMap(listSingers, singer, place, totalPrice);
            }
            input = s.nextLine();
        }
        sortAndPrint(listSingers);

    }

    private static void sortAndPrint(Map<String, Map<String, Integer>> listSingers) {
        listSingers.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(a -> System.out.printf("#  %s -> %d\n", a.getKey(), a.getValue()));
        });
    }

    private static void fillMap(Map<String, Map<String, Integer>> listSingers, String singer, String place, int totalPrice) {
        listSingers.putIfAbsent(place, new LinkedHashMap<>());
        if (!listSingers.get(place).containsKey(singer)) {
            listSingers.get(place).put(singer, totalPrice);
        } else {
            listSingers.get(place).put(singer, listSingers.get(place).get(singer) + totalPrice);
        }
    }
}
