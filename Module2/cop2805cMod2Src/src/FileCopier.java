import java.io.*;

public class FileCopier {
    // command line arguments:
    // args[0] is source file
    // args[1] is target file
    public static void main(String[] args) {
        // check command line arguments
        if (args.length != 2) {
            System.out.println("Usage: java FileCopier source target");
            System.exit(1);
        }

        // check existence of source file
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist.");
            System.exit(2);
        }

        // check existence of target file
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1] + " already exists.");
            System.exit(3);
        }

        int numberOfBytesCopied = 0;
        try (  // create an input stream
               BufferedInputStream input = new BufferedInputStream(
                       new FileInputStream(sourceFile));
               // create an output stream
               BufferedOutputStream output = new BufferedOutputStream(
                       new FileOutputStream(targetFile)); ) {
            // continuously read a byte from input and write to output
            int r = 0;
            while ((r = input.read()) != -1) {
                output.write((byte) r);
                numberOfBytesCopied++;
            }

        } catch (IOException ex) {
            System.err.println("Exception!" + ex);
        }

        // display the file size
        System.out.println(numberOfBytesCopied + " bytes copied.");
    }
}
