package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void add(Pet pet) {
        if (this.getCapacity() > this.data.size()) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }
    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        build.append("The grooming salon has the following clients:\n");
        for (Pet pet : data) {

            build.append(pet.getName());build.append(" ");
            build.append(pet.getOwner());build.append("\n");
        }
        return build.toString().trim();
    }

    public int getCount() {return this.data.size();}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }
}
