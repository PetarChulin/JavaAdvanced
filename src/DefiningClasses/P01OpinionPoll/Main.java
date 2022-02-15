package DefiningClassesExercise.P01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());

        List<Person> data = new ArrayList<>();
        while (n-- > 0) {

            String[] line = s.nextLine().split(" ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            Person person = new Person(name, age);
            if (age > 30) {
                data.add(person);
            }
        }
        data.sort(Comparator.comparing(Person::getName));
        data.forEach(System.out::println);
    }
}
