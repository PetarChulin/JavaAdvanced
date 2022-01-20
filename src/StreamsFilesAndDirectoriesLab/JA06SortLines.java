package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JA06SortLines {
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        String input = "C:\\Users\\PET\\Desktop\\input.txt";
        String output = "C:\\Users\\PET\\Desktop\\output.txt";

        List<String> lines = Files.readAllLines(Paths.get(input));
        Collections.sort(lines);
        for (String line : lines) {
            System.out.println(line);

        }
    }
}
