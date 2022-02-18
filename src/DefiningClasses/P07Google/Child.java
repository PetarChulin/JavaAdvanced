package DefiningClassesExercise.P07Google;

public class Child {

    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public static Child addChildren(Person person, String[] data) {
        String childName = data[2];
        String childBirthday = data[3];
        Child child = new Child(childName, childBirthday);
        person.getChildren().add(child);
        return child;
    }

    public String toString() {
        return childName + " " + childBirthday;
    }
}
