package StreamsFilesAndDirectoriesLab;
import java.io.FileInputStream;
import java.io.IOException;

public class JA01ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\PET\\Desktop\\input.txt";
        FileInputStream stream = new FileInputStream(path);
        int bite = stream.read();
        while (bite >= 0) {

            System.out.printf("%s ", Integer.toBinaryString(bite));
            bite = stream.read();
        }
    }
}
