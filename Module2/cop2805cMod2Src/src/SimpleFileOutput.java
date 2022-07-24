import java.io.IOException;
import java.io.FileOutputStream;

public class SimpleFileOutput {
    public static void main(String[] args) {
        final String FILENAME = "demofile.txt";
        final String DATA = "Hello, World!\nThis is a test.";
        byte[] data = DATA.getBytes();

        // open the file and write the byte array
        try (FileOutputStream fOutput = new FileOutputStream(FILENAME, true);) {
            fOutput.write(data);
        } catch (IOException ex) {
            System.err.println("Exception!" + ex);
        }
    }
}
