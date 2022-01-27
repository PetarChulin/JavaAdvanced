package JADVSetsandMapsAdvancedExercises;

import java.util.*;

import static java.lang.System.in;

public class JA09UserLogs {
    public static void main(String[] args) {
        Scanner s = new Scanner(in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String lines = s.nextLine();
        while (!lines.equals("end")) {

            String ip = lines.split("=")[1].split(" ")[0];
//            String message = lines.split(" ")[1].split("=")[1]
//                    .replaceAll("[\\']", "");
            String user = lines.split(" ")[2].split("=")[1];

            users.putIfAbsent(user, new LinkedHashMap<>());
            if (!users.get(user).containsKey(ip)) {
                users.get(user).put(ip, 1);
            } else {
                users.get(user).put(ip, users.get(user).get(ip) + 1);
            }
            lines = s.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : users.entrySet()) {
            System.out.printf("%s: \n", entry.getKey());
            System.out.println(Arrays.toString(entry.getValue().entrySet()
                    .toArray()).replaceAll("[\\[\\]]", "")
                    .replace("=", " => ") + ".");
        }
    }
}
