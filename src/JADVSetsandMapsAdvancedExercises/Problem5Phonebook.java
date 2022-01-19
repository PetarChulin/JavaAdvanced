package JADVSetsandMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Scanner;

public class Problem5Phonebook {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();
        HashMap<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {

            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phonebook.put(name, number);

            input = s.nextLine();
        }
        input = s.nextLine();
        while (!input.equals("stop")) {

            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s\n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }
            input = s.nextLine();
        }
    }
}
