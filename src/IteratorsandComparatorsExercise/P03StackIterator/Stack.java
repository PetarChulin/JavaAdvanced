package IteratorsandComparatorsExercise.P03StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.function.Consumer;

public class Stack implements Iterable<String> {

    ArrayDeque<String> stack;

    public Stack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(String digit) {
        this.stack.push(digit);
    }

    public void pop() {
        if (this.stack.isEmpty()) {
            System.out.println("No elements");
            return;
        }
        this.stack.pop();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private ArrayDeque<String> tempStack = new ArrayDeque<>(stack);

            @Override
            public boolean hasNext() {
                return !tempStack.isEmpty();
            }

            @Override
            public String next() {
                return tempStack.pop();
            }
        };
    }
}
