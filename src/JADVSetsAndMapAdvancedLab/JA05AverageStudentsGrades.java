package JADVSetsAndMapAdvancedLab;

import java.util.*;

public class JA05AverageStudentsGrades {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();


        String line = "";
        while (n != 0) {
            line = s.nextLine();

            String student = line.split(" ")[0];
            double grade = Double.parseDouble(line.split(" ")[1]);

            if (!students.containsKey(student)) {
                students.put(student, new ArrayList<>());
            }
            students.get(student).add(grade);
            n--;
        }
        students.forEach((key, value) -> {
            double sum = 0;
            for (Double grade : value) {
                sum += grade;
            }
            double average = sum / value.size();

            System.out.printf("%s -> ", key);
            value.forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)\n", average);
        });

//        students.forEach((key, value) -> {       //variant with stream 90/100
//            System.out.printf("%s -> ", key);
//            value.forEach(d -> System.out.printf("%.2f ", d));
//            System.out.printf("(avg: %.2f)\n",
//                    value.stream().mapToDouble(d -> d).average().orElse(0.0));
//        });

    }
}

