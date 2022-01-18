package JADVSetsandMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem2SetsofElements {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split(" ");

        LinkedHashSet<Integer> n = new LinkedHashSet<>();
        LinkedHashSet<Integer> m = new LinkedHashSet<>();

        setFill(s, n, input, 0);
        setFill(s, m, input, 1);
        n.retainAll(m);
        System.out.print(n.toString().replaceAll("[\\[\\],]" , ""));
//        for (Integer i : n) {
//            System.out.print(i + " ");
//        }
    }

    private static void setFill(Scanner s, LinkedHashSet<Integer> n, String[] input, int i2) {
        for (int i = 0; i < Integer.parseInt(input[i2]); i++) {
            n.add(s.nextInt());
        }
    }
}


