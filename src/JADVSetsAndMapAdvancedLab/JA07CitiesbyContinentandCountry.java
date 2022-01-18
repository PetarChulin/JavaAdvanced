package JADVSetsAndMapAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class JA07CitiesbyContinentandCountry {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        LinkedHashMap<String, Map<String, String>> list = new LinkedHashMap<>();

        while (n-- > 0) {

            String input = s.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];
            LinkedHashMap<String, String> listOfCountries = new LinkedHashMap<>();
            listOfCountries.put(country , city);
            if (!list.containsKey(continent)) {
                list.put(continent, listOfCountries);
            } else {
                list.get(continent).put(country, city);
            }
        }
    }
}
