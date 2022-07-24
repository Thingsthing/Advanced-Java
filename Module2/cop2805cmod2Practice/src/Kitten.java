// Kitten.java
// Represents cute little kittens; includes write/read operation in main method.
// D. Singletary
// 6/1/2016

import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Kitten implements Serializable {
    private String name;
    private String color;
    private double weight;
    private Date birthDate;
    private boolean litterTrained;

    private static final SimpleDateFormat DATEFORMATTER =
            new SimpleDateFormat("MM/dd/yyyy");

    // main method writes 3 kittens to an output file,
    // then reads them back in and displays them.
    public static void main(String[] args)
    {
        final String FILENAME = "kittens.dat";


        // write the objects to our file
        log("Writing data...");
        try (
                ObjectOutputStream output =
                        new ObjectOutputStream(new FileOutputStream(FILENAME)))
        {
            // declare 3 Kittens
            Kitten snowball = new Kitten("Snowball", "White", 6.0,
                    DATEFORMATTER.parse("3/31/2013"), false);
            Kitten fluffy = new Kitten("Fluffy", "Calico", 5.75,
                    DATEFORMATTER.parse("5/1/2014"), true);
            Kitten snuffles = new Kitten("Mr. Snuffles", "Black", 3.5,
                    DATEFORMATTER.parse("6/7/2015"), true);
            output.writeObject(snowball);
            output.writeObject(fluffy);
            output.writeObject(snuffles);
            log("wrote 3 kittens!");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            Throwable[] s = e.getSuppressed();
            if (s.length > 0)
                for (Throwable sx : s)
                    log("Suppressed: " + sx);
        }

        // read the objects from our file and display them
        log("Reading data...");
        try (
                ObjectInputStream input =
                        new ObjectInputStream(new FileInputStream(FILENAME)))
        {
            Kitten k1 = (Kitten)input.readObject();
            Kitten k2 = (Kitten)input.readObject();
            Kitten k3 = (Kitten)input.readObject();
            log("read 3 kittens!");
            log(k1);
            log(k2);
            log(k3);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            Throwable[] s = e.getSuppressed();
            if (s.length > 0)
                for (Throwable sx : s)
                    log("Suppressed: " + sx);
        }
    }

    // default constructor   
    public Kitten()
    {
        this.name = "";
        this.color = "";
        this.weight = 0.0;
        this.birthDate = new GregorianCalendar(1990, 1, 1).getTime();
        this.litterTrained = false;
    }

    // constructor which accepts 5 args to set properties
    public Kitten(String name, String color, double weight, Date birthDate,
                  boolean litterTrained)
    {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.birthDate = birthDate;
        this.litterTrained = litterTrained;
    }

    // accessors
    public String getName() { return this.name; }
    public String getColor() { return this.color; }
    public double getWeight() { return this.weight; }
    public Date getBirthDate() { return this.birthDate; }
    public boolean getLitterTrained() { return this.litterTrained; }

    // mutators
    public void setName(String name) { this.name = name; }
    public void setColor(String color) { this.color = color; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public void setLitterTrained(boolean litterTrained) {
        this.litterTrained = litterTrained;
    }

    public String toString()
    {
        return "Kitten [" + this.name +
                "] Color = " + this.color +
                ", Weight = " + this.weight +
                ", Birth Date = " + DATEFORMATTER.format(this.birthDate) +
                ", LitterTrained = " + this.litterTrained;
    }

    public static void log(Object o) { System.out.println(o); }
}