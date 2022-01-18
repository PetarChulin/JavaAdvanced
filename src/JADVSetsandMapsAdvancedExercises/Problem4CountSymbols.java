package JADVSetsandMapsAdvancedExercises;

import java.util.Scanner;
import java.util.TreeMap;

public class Problem4CountSymbols {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String text = s.nextLine();
        TreeMap<Character, Integer> occurrences = new TreeMap<>();

        countAndPrintSymbols(text, occurrences);
    }

    private static void countAndPrintSymbols(String text, TreeMap<Character, Integer> occurrences) {
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!occurrences.containsKey(symbol)) {
                occurrences.put(symbol, 1);
            } else {
                occurrences.replace(symbol, occurrences.get(symbol) + 1);
            }
        }
        occurrences.forEach((key, value) -> System.out.printf("%c: %d time/s\n", key, value));
    }
//        for (Map.Entry<Character, Integer> c : occurrences.entrySet()) {
//            System.out.printf("%c: %d time/s\n" , c.getKey() , c.getValue());
//        }
}

