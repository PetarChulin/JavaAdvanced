package JADVDefiningClasses.P09CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);
        String input = s.nextLine();
        List<Cat> cats = new ArrayList<>();

        while (!input.equals("End")) {

            String breed = input.split(" ")[0];
            String name = input.split(" ")[1];
            double value = Double.parseDouble(input.split(" ")[2]);

            Cat cat = new Cat(breed, name, value);
            cats.add(cat);
            input = s.nextLine();
        }
        input = s.nextLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(input)) {
                System.out.println(cat);
            }
        }
    }
}
