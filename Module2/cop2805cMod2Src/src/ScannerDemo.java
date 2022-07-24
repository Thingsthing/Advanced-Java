import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

public class ScannerDemo {
    public static void main(String[] args) {
        final String FILENAME = "demofile.txt";

        // create a file instance
        File file = new File(FILENAME);
        try (Scanner input = new Scanner(file);) {
            // read data from file
            while (input.hasNext()) {
                String nameFirst = input.next();
                String nameLast = input.next();
                int score = input.nextInt();
                System.out.println(nameFirst + " " + nameLast + " " + score);
            }
            // catch with suppressed
        } catch (IOException | InputMismatchException ex) {
            System.err.println("Exception! " + ex);
        }
    }
}
