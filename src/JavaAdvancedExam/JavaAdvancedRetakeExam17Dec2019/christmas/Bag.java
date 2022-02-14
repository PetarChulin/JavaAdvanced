package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.getCapacity() > this.data.size()) {
            this.data.add(present);
        }
    }

//    public boolean remove(String name) {
//        for (int i = 0; i < this.data.size(); i++) {
//            Present present = this.data.get(i);
//            if (present.getName().equals(name)) {
//                data.remove(i);
//                return false;
//            }
//        }
//        return false;
//    }

    public boolean remove(String name) {
        return this.data.removeIf(present -> present.getName().equals(name));
    }
//        for (Present present : this.data) {
//            if (present.getName().equals(name)) {
//                this.data.remove(present);
//                return true;
//            }
//        }
//        return false;


    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparingDouble(Present::getWeight)).get();
    }

    public Present getPresent(String name) {
        return data.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder build = new StringBuilder();
        build.append(String.format("%s bag contains:", this.color)).append("\n");
        for (Present present : data) {
            build.append(present).append("\n");
        }
        return build.toString();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Present> getData() {
        return data;
    }

    public void setData(List<Present> data) {
        this.data = data;
    }
}
