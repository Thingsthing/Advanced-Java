import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo
{
    public static void main(String[] args)
    {
        final String FILENAME = "demofile.txt";

        // open the file for reading  
        try (BufferedReader in = new BufferedReader(new FileReader(FILENAME)))
        {
            String inLine = null;

            // read data output to the file
            while ((inLine = in.readLine()) != null)
                System.out.println(inLine);
        } catch (IOException ex) {
            System.out.println("Exception! " + ex);
        }
    }
}