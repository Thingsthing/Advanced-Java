import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args)
    {
        final String FILENAME = "demofile.txt";

        File file = new File(FILENAME);
        if (file.exists())
            System.out.println("File " + FILENAME + " exists.");

        // create and/or open the file for writing
        try (PrintWriter output = new PrintWriter(file);) {
            // write formatted output to the file
            output.print("John Smith ");
            output.println(90);
            output.print("Eric Jones ");
            output.println(85);
            System.out.println("Wrote output file");
        } catch (IOException e) {
            System.err.println("Exception! " + e);
        }

        // close the file
        //output.close(); // not needed!
    }
}
