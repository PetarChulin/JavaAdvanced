package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class JA04ExtractIntegers {
    public static void main(String[] args) throws IOException {


        String input = "C:\\Users\\PET\\Desktop\\input.txt";
        String output = "C:\\Users\\PET\\Desktop\\output.txt";
        FileInputStream stream = new FileInputStream(input);
        Scanner s = new Scanner(stream);

        while (s.hasNext()) {
            if (s.hasNextInt()) {
                System.out.println(s.nextInt());
            }
            s.next();
        }
    }
}
