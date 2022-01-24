package JADVFunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JA01SortEvenNumbers {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split(", ");
        List<Integer> nums = new ArrayList<>();

        for (String value : input) {
            nums.add(Integer.parseInt(value));
        }
//        nums.removeIf(num -> num % 2 == 1);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 != 0) {
                nums.remove(i);
                i--;
            }
        }
        printNums(nums);
        Collections.sort(nums);
        printNums(nums);
    }

    private static void printNums(List<Integer> nums) {
        System.out.println(nums.toString().replaceAll("[\\[\\]]", ""));
    }
}
