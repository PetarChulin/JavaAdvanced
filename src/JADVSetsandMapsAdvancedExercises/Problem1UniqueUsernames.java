package JADVSetsandMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Problem1UniqueUsernames {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        LinkedHashSet<String> names = new LinkedHashSet<>();

        while (n-- > 0) {

            String line = s.nextLine();
            names.add(line);
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
