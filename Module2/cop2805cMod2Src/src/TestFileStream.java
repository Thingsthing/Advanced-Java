import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {
    public static void main(String[] args) {
        try (
                // Create an output stream for the file
                FileOutputStream output = new FileOutputStream("temp.dat"); ) {
            // output values to the file
            for (int i = 1; i <= 10; i++)
                output.write(i);
        } catch (IOException ex) {
            System.err.println("Output Exception: " + ex);
        }

        try (
                // Create an input stream for the file
                FileInputStream input = new FileInputStream("temp.dat"); ) {
            // read values from the file
            int value;
            while ((value = input.read()) != -1)
                System.out.print(value + " " );
        } catch (IOException ex) {
            System.err.println("Input Exception: " + ex);
        }
    }
}
