package JADVSetsAndMapAdvancedLab;

import java.util.*;

public class JA06ProductShop {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();
        TreeMap<String, Map<String, Double>> shopList = new TreeMap<>();

        while (!input.equals("Revision")) {

            input = getShopList(s, shopList, input);
        }
        printShopList(shopList);
    }

    private static void printShopList(TreeMap<String, Map<String, Double>> shopList) {
        for (Map.Entry<String, Map<String, Double>> entry : shopList.entrySet()) {
            System.out.printf("%s->\n", entry.getKey());
            for (Map.Entry<String, Double> doubleEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", doubleEntry.getKey(), doubleEntry.getValue());
            }
        }
    }

    private static String getShopList(Scanner s, TreeMap<String, Map<String, Double>> shopList, String input) {
        LinkedHashMap<String, Double> priceList;
        String shop = input.split(", ")[0];
        String product = input.split(", ")[1];
        double price = Double.parseDouble(input.split(" ")[2]);
        priceList = new LinkedHashMap<>();
        priceList.put(product, price);
        if (!shopList.containsKey(shop)) {
            shopList.put(shop, priceList);
        } else {
            shopList.get(shop).put(product, price);
        }
        input = s.nextLine();
        return input;
    }
}






