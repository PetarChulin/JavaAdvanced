package JADVSetsAndMapAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class JA04CountRealNumbers {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split(" ");
        Map<Double, Integer> num = new LinkedHashMap<>();

        for (String value : input) {
           if (!num.containsKey(Double.parseDouble(value))) {
               num.put(Double.parseDouble(value), 1);
           } else {
               num.put(Double.parseDouble(value), num.get(Double.parseDouble(value)) + 1);
           }
        }
        for (Double digit : num.keySet()) {

            System.out.printf("%.1f -> %d\n" , digit , num.get(digit));
        }

    }

}
