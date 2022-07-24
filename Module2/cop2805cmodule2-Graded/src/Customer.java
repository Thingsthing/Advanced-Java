//Customer.Java
//Customer information write/read
//Cho Cheung
//05/23/2022



import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Customer implements Serializable {
    private String lastName;
    private String firstName;
    private String phoneNumber;


    private static final SimpleDateFormat DATEFORMATTER =
            new SimpleDateFormat("MM/dd/yyyy");

    public static void main(String[] args) {
        //file name
        final String FILENAME = "customers.dat";

        //write objs to file
        System.out.print("Writing data...");
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILENAME));) {
            {
               Customer one = new Customer("Smith", "John", "904-555-1212");
               output.writeObject(one);
            }
        } catch (IOException e) {

        }

        System.out.print("Reading data...");
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(FILENAME));) {
            
            {
               Customer one = (Customer)input.readObject();
               System.out.println(one);
            }
        } catch (IOException | ClassNotFoundException e) {

        }

    }

    //default constructor
    public Customer() {
        this.lastName = "";
        this.firstName = "";
        this.phoneNumber = "";

    }

    //4 arg constructor
    public Customer(String lastName, String firstName, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;

    }
    //accessors
    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }



    //mutators
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String toString() {
        return "Customer [" + this.lastName + ", " + this.firstName +
                "] Phone = " + this.phoneNumber + ", Renewal Date = " ;
    }
}



