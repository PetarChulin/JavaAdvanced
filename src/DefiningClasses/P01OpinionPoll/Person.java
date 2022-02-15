package DefiningClassesExercise.P01OpinionPoll;

public class Person {

    public String name;
    public int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}
