package JADVSetsandMapsAdvancedExercises;

import java.util.*;
import java.util.stream.Collectors;

public class Problem8HandsOfCards {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> players = new LinkedHashMap<>();
        Map<String, Integer> setValue = new HashMap<>();
        while (!input.equals("JOKER")) {

            String[] turn = input.split(": ");
            String player = turn[0];
            String cards = turn[1];
            String[] cardsDeck = cards.split(", ");

            players.putIfAbsent(player, new LinkedHashSet<>());
            for (String card : cardsDeck) {
                players.get(player).add(card);
            }
//            cardMap.get(player).addAll(Arrays.stream(cardsDeck).collect(Collectors.toList()));
            input = scanner.nextLine();
        }
        cardPower(setValue);

        printResult(players, setValue);
    }

    private static void cardPower(Map<String, Integer> tableValue) {
        tableValue.put("2", 2);
        tableValue.put("3", 3);
        tableValue.put("4", 4);
        tableValue.put("5", 5);
        tableValue.put("6", 6);
        tableValue.put("7", 7);
        tableValue.put("8", 8);
        tableValue.put("9", 9);
        tableValue.put("J", 11);
        tableValue.put("Q", 12);
        tableValue.put("K", 13);
        tableValue.put("A", 14);
        tableValue.put("S", 4);
        tableValue.put("H", 3);
        tableValue.put("D", 2);
        tableValue.put("C", 1);
    }

    private static void printResult(Map<String, Set<String>> cardMap, Map<String, Integer> tableValue) {
        for (Map.Entry<String, Set<String>> entry : cardMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + getSumCards(entry.getValue(), tableValue));
        }
    }

    private static int getSumCards(Set<String> valueSet, Map<String, Integer> setValue) {
        int sum = 0;
        for (String values : valueSet) {
            String[] cardValue = values.split("");
            String key = cardValue[0];
            String value = cardValue[1];
            if (cardValue.length > 2) {
                value = cardValue[2];
                sum += 10 * setValue.get(value);
            } else {
                sum += setValue.get(key) * setValue.get(value);
            }
        }
        return sum;
    }
}
