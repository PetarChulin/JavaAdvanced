package JADVSetsandMapsAdvancedExercises;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem3PeriodicTable {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String[] input = s.nextLine().split(" ");
            Collections.addAll(elements, input);
        }
        System.out.println(elements.toString().replaceAll("[\\[\\],]" , ""));
    }
}
