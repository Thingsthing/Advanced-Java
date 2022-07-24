import java.io.*;

public class TestObjectStreamForArray {
    public static void main(String[] args) {
        final String FILENAME = "arrays.dat";
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"John", "Susan", "Kim"};
        boolean keepGoing = true;

        try (  // create an output stream for the file
               ObjectOutputStream output = new ObjectOutputStream(
                       new FileOutputStream(FILENAME, true)); ) {
            // write arrays to stream
            output.writeObject(numbers);
            output.writeObject(strings);
        } catch (IOException ex) {
            System.err.println("Exception! " + ex);
            keepGoing = false;
        }

        // if we encountered an error, stop processing
        if (keepGoing == false)
            System.exit(1);

        try (  // create an input stream
               ObjectInputStream input = new ObjectInputStream(
                       new FileInputStream(FILENAME)); ) {
            // read arrays from stream
            int[] newNumbers = (int[])(input.readObject());
            String[] newStrings = (String[])(input.readObject());

            // display arrays
            for (int i = 0; i < newNumbers.length; i++)
                System.out.print(newNumbers[i] + " ");

            System.out.println();

            for (int i = 0; i < newStrings.length; i++)
                System.out.println(newStrings[i] + " ");
        } catch (IOException ex) {
            System.err.println("Exception! " + ex);
        } catch (ClassNotFoundException ce) {
            System.err.println("Class not found" + ce);
        }
    }
}
