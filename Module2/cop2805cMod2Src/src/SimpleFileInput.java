import java.io.IOException;
import java.io.FileInputStream;

public class SimpleFileInput {
    public static void main(String[] args) {
        final String FILENAME = "demofile.txt";

        // open file, read byte-wise content and display
        try (FileInputStream fInput = new FileInputStream(FILENAME);) {
            int i = -1;
            do {
                i = fInput.read();
                if (i != -1)
                    System.out.print((char)i);
            } while (i != -1);
        } catch (IOException ex) {
            System.err.println("Exception! " + ex);
        }
    }
}
