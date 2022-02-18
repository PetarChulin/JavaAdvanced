package DefiningClassesExercise.P08FamilyTree;

import java.util.*;

import static DefiningClassesExercise.P08FamilyTree.Person.*;

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
            addChild(personName, parent, child);
            addParent(personName, parent, child);
        }
        searchedPerson = getNameByDate(personName, searchedPerson);
        record(personName, searchedPerson);

        System.out.println(searchedPerson + " " + personName.get(searchedPerson).getBirthday());
        printTree(personName, "Parents:", personName.get(searchedPerson).getParents());
        printTree(personName, "Children:", personName.get(searchedPerson).getChildren());
    }
}

