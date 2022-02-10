package IteratorsandComparatorsExercise.P01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class ListyIterator implements Iterator {
    private List<String> collection;
    private int index;

    public ListyIterator() {
        this.collection = new ArrayList<>();
        index = 0;
    }
    public ListyIterator(String... strings) {
        this();
        this.collection = Arrays.asList(strings);
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
