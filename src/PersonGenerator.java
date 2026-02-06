import static java.nio.file.StandardOpenOption.CREATE;

void main() {

    String ID = "";
    String fName = "";
    String lName = "";
    String title = "";
    int YOB = 0;
    String csvRec = "";
    boolean done = false;

    Scanner in = new Scanner(System.in);
    ArrayList<Person> people = new ArrayList<>();

    String regExPatternSixDigits = "^\\d{6}$";

    // Loop and collect data for the Person records into the array list
    do {

        ID = SafeInput.getRegExString(in, "Enter the ID [6 Digits Required!]", regExPatternSixDigits);
        fName = SafeInput.getNonZeroLenString(in, "Enter the first name");
        lName = SafeInput.getNonZeroLenString(in, "Enter the last name");
        title = SafeInput.getNonZeroLenString(in, "Enter the title");
        YOB = SafeInput.getRangedInt(in, "Enter the year for the age calc: ", 1000, 9999);

        // Convert the ID from String to int
        int personID;
        try {
            personID = Integer.parseInt(ID); // Convert the String ID to an int
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a valid numeric ID.");
            continue; // Skip this iteration if the ID is not a valid number
        }

        Person person = new Person(fName, lName, title,YOB,personID);
        people.add(person);

        done = SafeInput.getYNConfirm(in, "Are you done");
    } while (!done);

    //For debugging purposes
    for( Person p: people)
        System.out.println(p);

    File workingDirectory = new File(System.getProperty("user.dir"));
    //Path file = Paths.get(workingDirectory.getPath() + "\\src\\Persondata.txt");             // Windows Filesystem
    Path file = Paths.get(workingDirectory.getPath(), "resources", "Persondata.txt");   // Cross System Friendly

    // Note from Van Diep: I am on Linux, so the file path I save it on may be different.
    // I had to change the file path to be cross-platform compatible due to Linux's filesystem being different
    // from Windows. Had I not done this, then I would not be able to show the file on the file on the
    // IntelliJ IDE.


    try {
        // Typical java pattern of inherited classes
        // we wrap a BufferedWriter around a lower level BufferedOutputStream
        OutputStream out =
                new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(out));

        for (Person person : people) {
            writer.write(person.toCSV());

            // rec. length() is how many chars to write (all)
            writer.newLine();  // adds the new line

        }
        writer.close(); // must close the file to seal it and flush buffer
        IO.println("Data file written!");
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Dump the array list for inspection
//        for(String rec : recs)
//        {
//            System.out.println(rec);
//        }

}