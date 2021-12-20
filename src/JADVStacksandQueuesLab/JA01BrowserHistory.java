package JADVStacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class JA01BrowserHistory {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if(input.equals("back")){
                if(stack.size() <= 1){
                    System.out.println("no previous URLs");
                    input = s.nextLine();
                    continue;
                }else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }else {
                stack.push(input);
                System.out.println(input);
            }
            input = s.nextLine();
        }

    }
}
