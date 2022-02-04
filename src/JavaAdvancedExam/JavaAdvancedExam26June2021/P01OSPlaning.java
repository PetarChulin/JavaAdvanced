package JavaAdvancedExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class P01OSPlaning {
    public static void main(String[] args) {

        Scanner s = new Scanner(in);

        int[] firstInput = Arrays.stream(s.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] secondInput = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int taskValue = Integer.parseInt(s.nextLine());

        ArrayDeque<Integer> task = new ArrayDeque<>();
        ArrayDeque<Integer> thread = new ArrayDeque<>();

        for (Integer integer : firstInput) {
            task.push(integer);
        }
        for (Integer integer : secondInput) {
            thread.offer(integer);
        }
        while (!task.isEmpty() && !thread.isEmpty()) {
            if (taskValue == task.peek()) {
                int tempTask = task.peek();
                int tempThread = thread.peek();
                System.out.printf("Thread with value %d killed task %d\n", tempThread, tempTask);
                break;
            }
            if (thread.peek() >= task.peek()) {
                task.pop();
                thread.poll();
            } else if (thread.peek() < task.peek()) {
                thread.poll();
            }
        }
        System.out.println(thread.toString().replaceAll("[\\[\\],]" , ""));
    }
}
