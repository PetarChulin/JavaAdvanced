package JADVStacksandQueuesExercise;

import java.util.Scanner;

public class JA07RecursiveFibonacci {
    public static long[] fibonacci;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        fibonacci = new long[n + 1];
        System.out.println(fib(n));
    }

    public static long fib(int n) {
        if (n <= 1) {
            return 1;
        }

        if (fibonacci[n] != 0) {
            return fibonacci[n];
        }
        return fibonacci[n] = fib(n - 1) + fib(n - 2);
    }
}

