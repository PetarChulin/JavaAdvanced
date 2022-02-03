package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int capacity;
    public List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public List<Person> getRoster() {
        return roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.roster.size();
    }

    public void add(Person person) {
        if (this.getCapacity() > this.getRoster().size()) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : roster) {
            if (person.getName().equals(name)) {
                this.roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        build.append(String.format("The people in the hotel %s are:\n", getName()));
        for (Person person : roster) {
            build.append(person.toString()).append("\n");
        }
        return build.toString();
    }
}
