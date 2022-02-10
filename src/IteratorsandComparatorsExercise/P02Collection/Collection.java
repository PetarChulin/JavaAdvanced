package IteratorsandComparatorsExercise.P02Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection  {

    public List<String> collection;
    private int index;

    public Collection() {
        this.collection = new ArrayList<>();
        index = 0;
    }

    public void create(String[] data) {
        this.collection.addAll(Arrays.asList(data).subList(1, data.length));
    }

    public void print() {
        if (this.collection.isEmpty()) {
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(this.collection.get(index));
    }
    public void printAll() {
        if (this.collection.isEmpty()) {
            System.out.println("Invalid Operation!");

        }
        StringBuilder build = new StringBuilder();
        for (String s : this.collection) {
           build.append(s).append(" ");
        }
        System.out.println(build.toString());
    }

    public boolean move() {
        if (this.hasNext()) {
            this.next();
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index + 1 < this.collection.size();
    }

    public String next() {
        return this.collection.get(index++);
    }



}
