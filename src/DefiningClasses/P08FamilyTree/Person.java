package DefiningClassesExercise.P08FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Person {

    public String name;
    public String birthday;
    public List<String> parents;
    public List<String> children;

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public static String record(Map<String, Person> tree, String data) {
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

    public static String getNameByDate(Map<String, Person> personName, String searchedPerson) {
        if (searchedPerson.contains("/")) {
            for (Person entry : personName.values()) {
                if (entry.getBirthday().equals(searchedPerson)) {
                    searchedPerson = entry.getName();
                }
            }
        }
        return searchedPerson;
    }

    public static void addParent(Map<String, Person> personName, String parent, String child) {
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

    public static void addChild(Map<String, Person> personName, String parent, String child) {
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
    }

    public List<String> getParents() {
        return parents;
    }


    public List<String> getChildren() {
        return children;
    }
    public static void printTree(Map<String, Person> personName, String s2, List<String> parents) {
        System.out.println(s2);
        parents.forEach(p -> System.out.println(record(personName, p)));
    }
   }
