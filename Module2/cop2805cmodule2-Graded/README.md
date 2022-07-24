# COP2805C Module 2 Graded Programming Assignment

Implement a public Customer class which contains the following members:

    private String lastName
    private String firstName
    private String phoneNumber
    private Date renewalDate

Implement a 0-arg and a 4-arg constructor in this class which initializes/sets the above members. The renewalDate member should be initialized to 1/1/1970 in the default constructor.

Implement all associated accessors and mutators using the conventions discussed during week 1 (use "get" and "set" combined with the member variable names). Mutator parameter names should be named using the member variable names (use "this.membername = membername" for assignment).

Implement a public toString method which returns a String representing a customer with the following format:

    Customer [Smith, John] Phone = 904-555-1212, Renewal Date = 07/01/2016

Write a main method for the class which writes and then reads an array of customer objects using ObjectOutputStream and ObjectInputStream and a data file named "customers.dat". The following four customers should be instantiated as an array using the data values shown below and written to the data file, then read and displayed from the data file:

      Customer [Smith, John] Phone = 904-555-1212, Renewal Date = 07/01/2016
      Customer [Brown, Sally] Phone = 904-555-5555, Renewal Date = 09/30/2016
      Customer [Park, Tyrell] Phone = 904-555-7777, Renewal Date = 10/31/2016
      Customer [McDowell, Sully] Phone = 904-555-9999, Renewal Date = 12/31/2016

Use a named constant (final String, all upper-case name) for the file name and any other constant values. Be sure to catch the appropriate exceptions, and use try-with-resources as described in class. Your catch block should also check for suppressed exceptions.

Attach and submit your Customer.java class to this assignment.

Expected output for your program is shown below (the last four lines result from printing each Customer array element via the toString method):

      Writing data...wrote 4 customers!
      Reading data...Read 4 customers!
      Customer [Smith, John] Phone = 904-555-1212, Renewal Date = 07/01/2016
      Customer [Brown, Sally] Phone = 904-555-5555, Renewal Date = 09/30/2016
      Customer [Park, Tyrell] Phone = 904-555-7777, Renewal Date = 10/31/2016
      Customer [McDowell, Sully] Phone = 904-555-9999, Renewal Date = 12/31/2016
