package JADVStacksandQueuesExercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class JA05Robotics {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split(";");
        String startTime = s.nextLine();
        Map<String, Integer> robot = new LinkedHashMap<>();
        ArrayDeque<String> products = new ArrayDeque<>();


        for (String value : input) {
            String robotName = value.split("-")[0];
            int robotTime = Integer.parseInt(value.split("-")[1]);
            robot.put(robotName, robotTime);
        }
        int hour = Integer.parseInt(startTime.split(":")[0]);
        int min = Integer.parseInt(startTime.split(":")[1]);
        int sec = Integer.parseInt(startTime.split(":")[2]);
        int startTimeSec = (hour * 3600) + (min * 60) + sec;
        int[] workCapacity = new int[robot.size()];

        String product = s.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = s.nextLine();
        }
        while (!products.isEmpty()) {
            String currProduct = products.poll();
            startTimeSec++;
            boolean ifWorks = false;
            for (int i = 0; i < workCapacity.length; i++) {
                if (workCapacity[i] > 0) {
                    workCapacity[i]--;
                }
            }
            for (int i = 0; i < workCapacity.length; i++) {
                if (workCapacity[i] == 0) {
                    int count = 0;
                    for (Map.Entry<String, Integer> entry : robot.entrySet()) {
                        if (count == i) {
                            workCapacity[i] = entry.getValue();
                            printQueue(startTimeSec, currProduct, entry);
                            ifWorks = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if (!ifWorks) {
                products.offer(currProduct);
            }
        }
    }

    private static void printQueue(int startTimeSec, String currProduct, Map.Entry<String, Integer> entry) {
        int hoursTotal = (startTimeSec / 3600) % 24;
        int minTotal = (startTimeSec / 60) % 60;
        int secTotal = startTimeSec % 60;
        System.out.println(entry.getKey() + " - " + currProduct +
                String.format(" [%02d:%02d:%02d]", hoursTotal, minTotal, secTotal));
    }
}
