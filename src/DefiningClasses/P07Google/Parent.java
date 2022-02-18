package DefiningClassesExercise.P07Google;

public class Parent {

    private String name;
    private String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public static Parent addParents(Person person, String[] data) {
        String parentName = data[2];
        String birthday = data[3];
        Parent parent = new Parent(parentName, birthday);
        person.getParents().add(parent);
        return parent;
    }

    public String toString() {
        return name + " " + birthday;
    }
}
