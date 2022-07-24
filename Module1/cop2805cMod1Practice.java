// LambdaSummer.java
// Cho Cheung
// 5/17/2022
// Implement an addition interface method using a lambda expression

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

interface ArraySummer {
    // sum method sums an array of integers
    public int summer(Integer[] array);
}

interface ArraySummerD {
    // sum method sums an array for doubles
    public double summer(Double[]array);
}

public class LambdaSummer {

    public static void main(String[] args) {
        // test data
        Integer[] testArray = { 1, 3, 5, 7, 9 };
        Double[] testArrayD = {1.0, 3.1, 5.2, 7.3, 9.4};

        //declare ArraySummerD lambda expression
        ArraySummerD ad = (array) ->
        {
            double sum = 0;
            for (double i : array)
                sum+= i;
            return sum;
        };

        // declare ArraySummer lambda expression
        ArraySummer as = (array) ->
        {
            int sum = 0;
            for (Integer i : array)
                sum += i;
            return sum;
        };

        // use java.util.Arrays.toString to cleanly print the Integer test data
        //System.out.println("The sum of " + java.util.Arrays.toString(testArray) +
        //" is " + as.summer(testArray));

        // use java.util.Arrays.toString to cleanly print the Double test data
        System.out.println("The sum of " + java.util.Arrays.toString(testArrayD) +
                " is " + ad.summer(testArrayD));

        // now read in a list of values from a CSV file and add them
        ArrayList<String> list = CSVReader.readCSV("/Users/vince/IdeaProjects/demo/src/test/java/doubles.csv");
        testArrayD = NumberCollection.toDoubleArray(list);
        System.out.println("The sum of " + java.util.Arrays.toString(testArrayD) +
                " is " + ad.summer(testArrayD));


    }
}


class CSVReader {
    // read tokens from a CSV file
    public static ArrayList<String> readCSV(String fileName) {
        ArrayList<String> list = new ArrayList<String>();
        String token = "";
        //try-with
        try (Scanner sc = new Scanner(new File(fileName));) {

            sc.useDelimiter(",");
            while (sc.hasNext()) {
                token = sc.next();
                list.add(token);
            }
            sc.close();
        } catch(Exception e) {}

        return list;
    }
}

class NumberCollection {
    //doubles
    public static Double[] toDoubleArray(ArrayList<String> sList) {
        int size = sList.size();
        Double[] iArray = new Double[size];
        int index = 0;

        for (String s : sList) {
            try {
                iArray[index++] = Double.parseDouble(s);
            } catch(NumberFormatException nfe) {
                System.err.println("Parsing failed for s");
            }
        }
        return iArray;
    }
    //for ints
    public static Integer[] toIntegerArray(ArrayList<String> sList) {
        int size = sList.size();
        Integer[] iArray = new Integer[size];
        int index = 0;

        for (String s : sList) {
            try {
                iArray[index++] = Integer.parseInt(s);
            } catch(NumberFormatException nfe) {
                System.err.println("Parsing failed for s");
            }
        }

        return iArray;
    }
}