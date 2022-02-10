package IteratorsandComparatorsExercise.P02Collection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String [] data = s.nextLine().split("\\s+");
        Collection collection = new Collection();
        collection.create(data);
        String command = s.nextLine();
        while (!command.equals("END")) {

            switch (command) {
                case "Move" :
                    System.out.println(collection.move());
                    break;
                case "HasNext" :
                    System.out.println(collection.hasNext());
                    break;
                case "Print":
                    collection.print();
                    break;
                case "PrintAll":
                   collection.printAll();
            }
            command = s.nextLine();
        }
    }
}
