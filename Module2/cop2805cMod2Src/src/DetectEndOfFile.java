import java.io.*;

public class DetectEndOfFile {
    public static void main(String[] args) {
        final String FILENAME = "temp.dat";
        try (   // create an output stream for file
                DataOutputStream output = new DataOutputStream(new FileOutputStream(FILENAME)); ) {
            // write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(95.0);
            output.writeUTF("George");
            output.writeDouble(89.9);
        }  catch (IOException ex) {
            System.err.println("Output Exception: " + ex);
        }

        try (   // create an input stream for the file
                DataInputStream input = new DataInputStream(new FileInputStream(FILENAME)); ) {
            // read student test scores from the file
            while (true)
                System.out.println(input.readUTF() + " " + input.readDouble());
        } catch (EOFException ex) {
            System.out.println("All data have been read");
        } catch (IOException ex) {
            System.err.println("Input Exception: " + ex);
        }
    }
}