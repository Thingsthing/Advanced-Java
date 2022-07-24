# cop2805cMod2Practice
# Practice Exercise for COP2805C Module 2

Implement a public Kitten class which contains the following members:

    private String name
    private String color
    private double weight
    private Date birthDate
    private boolean litterTrained

Implement a 0-arg and a 5-arg constructor in this class which initializes/sets the above members. The  birthDate member should be initialized to 1/1/1990 in the default constructor.

Implement all associated accessors and mutators using the conventions discussed in Unit 1 (use "get" and "set" combined with the member variable names). Mutator parameter names should be named using the member variable names (use "this.membername = membername" for assignment).

Implement a public toString method which returns a String representing a kitten with the following format (using "Snowball" as an example):

    Kitten [Snowball] Color = White, Weight = 6.0, Birth Date = 03/31/2013, LitterTrained = false

Write a main method for the class which writes and then reads individual kitten objects using ObjectOutputStream and ObjectInputStream and a data file named "kittens.dat". The following three kittens should be instantiated as individual objects (not as an array) and written to the data file using the values shown, then read and displayed from the data file:

    Kitten [Snowball] Color = White, Weight = 6.0, Birth Date = 03/31/2013, LitterTrained = false
    Kitten [Fluffy] Color = Calico, Weight = 5.75, Birth Date = 05/01/2014, LitterTrained = true
    Kitten [Mr. Snuffles] Color = Black, Weight = 3.5, Birth Date = 06/07/2015, LitterTrained = true

Use a named constant (final String, all upper-case name) for the file name and for any other constant values. Be sure to catch the appropriate exceptions, and use try-with-resources as described in class. Your catch block should also check for suppressed exceptions.

Expected output for your program is shown below (the last three lines result from printing each Kitten object via the toString method):

    Writing data...wrote 3 kittens!
    Reading data...read 3 kittens!
    Kitten [Snowball] Color = White, Weight = 6.0, Birth Date = 03/31/2013, LitterTrained = false
    Kitten [Fluffy] Color = Calico, Weight = 5.75, Birth Date = 05/01/2014, LitterTrained = true
    Kitten [Mr. Snuffles] Color = Black, Weight = 3.5, Birth Date = 06/07/2015, LitterTrained = true
