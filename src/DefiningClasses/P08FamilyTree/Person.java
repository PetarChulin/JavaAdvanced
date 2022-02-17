package DefiningClassesExercise.P08FamilyTree;

import java.util.ArrayList;
import java.util.List;

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

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }
}
