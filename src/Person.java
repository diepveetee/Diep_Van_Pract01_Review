import java.util.Objects;
import java.time.LocalDate;
import java.util.Calendar;


public class Person {

    // Fields (Instance Variables)
    private String firstName;
    private String lastName;
    private final int IDNum;  // ID should never change sequence of digits
    private String title;   // Prefix (Mr., Mrs., Prof., Dr., etc.)
    private int YOB;        // Year of birth (should be between 1940 and 2010)

    // Constructors


    /**
     * Constructor that initializes a Person with first name, last name, and year of birth.
     * The ID is generated automatically.
     *
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param YOB The year of birth of the person.
     * @throws IllegalArgumentException If YOB is outside the range 1940-2010.
     */
    public Person(String firstName, String lastName, String title, int YOB, int IDNum)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.IDNum = IDNum;    // Assign the passed ID
        this.title = title;
        setYOB(YOB);  // Ensure valid year range
    }

    /**
     * Constructor that initializes a Person with first name, last name, and year of birth.
     * The ID is generated automatically.
     *
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param YOB The year of birth of the person.
     * @throws IllegalArgumentException If YOB is outside the range 1940-2010.
     */

    // Getters and Setters for Instance Variables


    /**
     * Retrieves the unique ID number of the person.
     * @return The ID number.
     */
    public int getIDNum() {
        return IDNum;
    }


    /**
     * Prevent changing the ID after initialization
     * @param ID The ID number to set. This will always throw an exception.
     * @throws UnsupportedOperationException This method always throws an exception since ID cannot be changed.
     */
    public void setID(String ID) {
        throw new UnsupportedOperationException("ID cannot be changed once set");
    }

    /**
     * Retrieves the first name of the person.
     * @return The first name of the person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     * @param firstName The new first name for the person.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the person.
     * @return The last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     * @param lastName The new last name for the person.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the title of the person.
     * @return The title of the person.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the person.
     * @param title The new title for the person.
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Retrieves the year of birth of the person.
     * @return The year of birth.
     */
    public int getYOB() {
        return YOB;
    }

    /**
     * Sets the year of birth of the person, ensuring that it is within a valid range.
     *
     * @param YOB The new year of birth for the person.
     * @throws IllegalArgumentException If YOB is outside the range 1940-2010.
     */
    public void setYOB(int YOB) {
        if (YOB < 1940 || YOB > 2010) {
            throw new IllegalArgumentException("YOB must be between 1940 and 2010");
        }
        this.YOB = YOB;
    }

    // Utility Methods

    /**
     * Retrieves the full name of the person (first name + last name).
     * @return full name of person.
     */
    public String fullName() {
        return firstName + " " + lastName;
    }


    /**
     * Retrieves the formal name of the person (title + full name).
     * @return The formal name of the person.
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Calculates the age of the person based on current year.
     * @return The age of the person as a string.
     */

    public String getAge() {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - YOB;
        return String.valueOf(age);
    }

    /**
     * Calculates the age of the person based on a specific year.
     * @param year The year to calculate the age.
     * @return The age of the person as a string.
     * NEED TO ADD CALENDAR
     */
    public String getAge(int year) {
        // Use Calendar to get the current year
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        // Calculate age using the provided year
        return String.valueOf(year - YOB);

    }



    /**
     * Converts the Person object to a string representation.
     * @return A string representing the Person object.
     */
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", ID=" + IDNum + ", title=" + title + ", YOB=" + YOB + "]";
    }


    /**
     * Computes the hash code for the Person object based on the ID number.
     *
     * @return The hash code of the Person object.
     */

    /**
     * Converts the Person object to a CSV (Comma Separated Values) string representation.
     * The fields are ordered as: firstName, lastName, IDNum, title, and YOB.
     *
     * @return A CSV string representation of the Person object.
     */
    public String toCSV() {
        return firstName + "," + lastName + "," + IDNum + "," + title + "," + YOB;
    }


    /**
     * Converts the Person object to a JSON string representation.
     * The JSON structure includes: IDNum, firstName, lastName, and YOB.
     *
     * @return A JSON string representation of the Person object.
     */
    public String toJSONRecord() {
        char DQ = '"';  // Double quote character
        return "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + "," +
                DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + "," +
                DQ + "lastName" + DQ + ":" + DQ + this.lastName + DQ + "," +
                DQ + "YOB" + DQ + ":" + this.YOB + "}";
    }


    /**
     * Converts the Person object to an XML string representation.
     * The XML structure includes: firstName, lastName, ID, title, and YOB.
     *
     * @return A string representing the Person object in XML format.
     */
    public String toXML() {
        return "<Person>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<ID>" + IDNum + "</ID>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }
}

