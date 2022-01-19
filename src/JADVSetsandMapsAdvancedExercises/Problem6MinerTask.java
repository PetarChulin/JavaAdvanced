package JADVSetsandMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Problem6MinerTask {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        LinkedHashMap<String, Integer> resource = new LinkedHashMap<>();
        String line = s.nextLine();

        while (!line.equals("stop")) {

            if (!resource.containsKey(line)) {
                resource.put(line, Integer.parseInt(s.nextLine()));
            } else {
                resource.put(line, resource.get(line) + Integer.parseInt(s.nextLine()));
            }
            line = s.nextLine();
        }
        resource.forEach((key,value) -> {System.out.printf("%s -> %d\n" ,key , value);});
    }
}

