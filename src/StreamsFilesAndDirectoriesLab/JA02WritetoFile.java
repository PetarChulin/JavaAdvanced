package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JA02WritetoFile {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\PET\\Desktop\\input.txt";
        String output = "C:\\Users\\PET\\Desktop\\output.txt";
        FileInputStream stream = new FileInputStream(input);
        FileOutputStream outStream = new FileOutputStream(output);
        int bite = stream.read();
        Character[] chars = {'.', ',', '!', '?'};
        List<Character> symbols = Arrays.asList(chars);

        while (bite >= 0) {
            if (!symbols.contains((char) bite)) {
                outStream.write(bite);
                System.out.print((char) bite);
            }
            bite = stream.read();
        }
    }
}
