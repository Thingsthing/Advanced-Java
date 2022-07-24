import java.io.*;
import java.util.Date;

public class TestObjectStream {
    public static void main(String[] args) {
        final String FILENAME = "objects.dat";
        boolean keepGoing = true;

        // write an object stream to a file
        System.out.println("writing data");
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILENAME)); ) {
            // write a UTF string, a double, and a Date object
            output.writeUTF("John Smith");
            output.writeDouble(85.5);
            output.writeObject(new Date());
        } catch (IOException ex) {
            System.err.println("Exception! " + ex);
            keepGoing = false;
        }

        // if we encountered an error, stop processing
        if (keepGoing == false)
            System.exit(1);

        // now read the objects back in
        System.out.println("reading data");
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(FILENAME)); ) {
            // Read a UTF string, a double, and a Date object
            String s = input.readUTF();
            double d = input.readDouble();
            Date date = (Date)input.readObject();
            System.out.println("read " + s + ", " + d + ", " + date);
        } catch (IOException ex) {
            System.err.println("Exception! " + ex);
        } catch (ClassNotFoundException ce) {
            System.err.println("Class not found" + ce);
        }
    }
}
