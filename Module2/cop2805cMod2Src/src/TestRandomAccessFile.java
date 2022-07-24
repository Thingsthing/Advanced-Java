import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {
    public static void main(String[] args) {
        final String FILENAME = "inout.dat";
        try ( // create a random access file
              RandomAccessFile inout = new RandomAccessFile(FILENAME, "rw"); ) {
            // clear the file contents
            inout.setLength(0);

            // write new integers
            for (int i = 0; i < 200; i++)
                inout.writeInt(i);

            // display the current file size
            System.out.println("current file size is " + inout.length());

            // get the first number
            inout.seek(0); // set file pointer to beginning
            System.out.println("the first number is " + inout.readInt());

            // get the second number
            inout.seek(1 * 4); // move to the second 4-byte int
            System.out.println("the second number is " + inout.readInt());

            // get the last number
            inout.seek(inout.length() - 4);
            System.out.println("the last number is " + inout.readInt());

            // modify the last number
            inout.seek(inout.length() - 4);
            inout.writeInt(555);

            inout.seek(inout.length() - 4);
            System.out.println("the last number is " + inout.readInt());

            // append a new number
            inout.seek(inout.length());
            inout.writeInt(999);

            // display the new file size
            System.out.println("new file size is " + inout.length());

            // get the new eleventh number
            inout.seek(inout.length() - 4);
            System.out.println("the last number is " + inout.readInt());
        } catch (IOException ex) {
            System.err.println("Exception!" + ex);
        }
    }
}
