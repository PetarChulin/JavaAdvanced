package DefiningClassesExercise.P08FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Map<String, Person> personName = new LinkedHashMap<>();
        List<String> relatives = new ArrayList<>();
        String searchedPerson = s.nextLine();
        String input = s.nextLine();

        while (!input.equals("End")) {
            String[] line = input.split(" ");
            if (input.contains("-")) {
                relatives.add(input);
            } else {
                if (line.length == 3) {
                    String name = input.split("\\s\\d")[0];
                    String bDay = input.split(" ")[2];
                    Person person = new Person(name, bDay);
                    personName.put(name, person);
                }
            }
            input = s.nextLine();
        }
        for (String entry : relatives) {
                String parent = entry.split(" - ")[0];
                String child = entry.split(" - ")[1];
            if (!parent.contains("/")) {
                if (personName.containsKey(parent)) {
                    personName.get(parent).getChildren().add(child);
                }
            } else {
                for (Person person : personName.values()) {
                    if (person.getBirthday().equals(parent)) {
                        person.getChildren().add(child);
                        break;
                    }
                }
            }
            if (!child.contains("/")) {
                if (personName.containsKey(child)) {
                    personName.get(child).getParents().add(parent);
                }
            } else {
                for (Person person : personName.values()) {
                    if (person.getBirthday().equals(child)) {
                        person.getParents().add(parent);
                        break;
                    }
                }
            }
        }
        searchedPerson = getNameByDate(personName, searchedPerson);
        record(personName, searchedPerson);

        System.out.println(searchedPerson + " " + personName.get(searchedPerson).getBirthday());
        printTree(personName, "Parents:", personName.get(searchedPerson).getParents());
        printTree(personName, "Children:", personName.get(searchedPerson).getChildren());
    }

    private static void printTree(Map<String, Person> personName, String s2, List<String> parents) {
        System.out.println(s2);
        parents.forEach(p -> System.out.println(record(personName, p)));
    }

    private static String getNameByDate(Map<String, Person> personName, String searchedPerson) {
        if (searchedPerson.contains("/")) {
            for (Person entry : personName.values()) {
                if (entry.getBirthday().equals(searchedPerson)) {
                    searchedPerson = entry.getName();
                }
            }
        }
        return searchedPerson;
    }

    private static String record(Map<String, Person> tree, String data) {
        String finalPrint = "";
        if (data.contains("/")) {
            for (Person p : tree.values()) {
                if (data.equals(p.getBirthday())) {
                    finalPrint = p.getName() + " " + data;
                }
            }
        } else {
            finalPrint = data + " " + tree.get(data).getBirthday();
        }
        return finalPrint;
    }
}

