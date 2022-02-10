package IteratorsandComparatorsExercise.P01ListyIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String [] data = s.nextLine().split("\\s+");
        ListyIterator listyIterator = new ListyIterator();
        listyIterator.create(data);

        String command = s.nextLine();
        while (!command.equals("END")) {

            switch (command) {
                case "Move" :
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext" :
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
            }
        command = s.nextLine();
        }
    }
}
