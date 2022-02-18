package DefiningClassesExercise.P07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static DefiningClassesExercise.P07Google.Car.setCar;
import static DefiningClassesExercise.P07Google.Child.addChildren;
import static DefiningClassesExercise.P07Google.Company.setCompany;
import static DefiningClassesExercise.P07Google.Parent.addParents;
import static DefiningClassesExercise.P07Google.Pokemon.addPokemon;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        Map<String, Person> people = new HashMap<>();

        String input = s.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String typeData = data[1];

            people.putIfAbsent(name, new Person());

            switch (typeData) {
                case "company":
                    setCompany(people.get(name), data);
                    break;
                case "pokemon":
                    addPokemon(people.get(name), data);
                    break;
                case "parents":
                    addParents(people.get(name), data);
                    break;
                case "children":
                    addChildren(people.get(name), data);
                    break;
                case "car":
                    setCar(people.get(name), data);
                    break;
            }
            input = s.nextLine();
        }
        String searchedPerson = s.nextLine();
        System.out.println(searchedPerson);

        Person person = people.get(searchedPerson);
        System.out.println(person.getPersonInfo());
    }
  }
