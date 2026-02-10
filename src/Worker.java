public class Worker extends Person {
    private double hourlyPayRate;

    /**
     * Constructor to initialize a Worker object with necessary fields.
     *
     * @param IDNum The unique ID number for the worker.
     * @param firstName The first name of the worker.
     * @param lastName The last name of the worker.
     * @param title The title (e.g., Mr., Mrs., Dr.) of the worker.
     * @param YOB The year of birth of the worker.
     * @param hourlyPayRate The hourly pay rate of the worker.
     */
    public Worker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(IDNum, firstName, lastName, title, YOB);  // Call the parent (Person) constructor
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * Retrieves the hourly pay rate of the worker.
     *
     * @return The hourly pay rate of the worker.
     */
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    /**
     * Sets the hourly pay rate of the worker.
     *
     * @param hourlyPayRate The new hourly pay rate to set.
     */
    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * Calculates the weekly pay for the worker based on hours worked.
     * Regular hours (up to 40) are paid at the standard hourly rate.
     * Overtime hours (over 40) are paid at time and a half.
     *
     * @param hoursWorked The number of hours worked in a week.
     * @return The total weekly pay, including regular and overtime pay.
     */
    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);  // Regular hours are capped at 40
        double overtimeHours = Math.max(0, hoursWorked - 40);  // Overtime hours are above 40

        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;  // Overtime is time and a half

        return regularPay + overtimePay;
    }

    /**
     * Displays the breakdown of weekly pay, including regular and overtime hours, and the total pay.
     * The regular hours are calculated at the hourly pay rate, and the overtime hours are calculated at time and a half.
     *
     * @param hoursWorked The number of hours worked in a week.
     */
    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);  // Regular hours
        double overtimeHours = Math.max(0, hoursWorked - 40);  // Overtime hours
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.println("Regular Hours: " + regularHours + " x $" + hourlyPayRate + " = $" + regularPay);
        System.out.println("Overtime Hours: " + overtimeHours + " x $" + hourlyPayRate * 1.5 + " = $" + overtimePay);
        System.out.println("Total Pay: $" + totalPay);
    }

    /**
     * Converts the Worker object to a CSV (Comma Separated Values) string representation.
     * The fields are ordered as: IDNum, firstName, lastName, title, YOB, and hourlyPayRate.
     *
     * @return A CSV string representation of the Worker object.
     */
    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
    }

    /**
     * Converts the Worker object to an XML string representation.
     * The XML structure includes: firstName, lastName, IDNum, title, YOB, and hourlyPayRate.
     *
     * @return A string representing the Worker object in XML format.
     */
    @Override
    public String toXML() {
        return super.toXML().replace("</Person>", "")
                + "<hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate>"
                + "</Person>";
    }

    /**
     * Converts the Worker object to a JSON string representation.
     * The JSON structure includes: IDNum, firstName, lastName, title, YOB, and hourlyPayRate.
     *
     * @return A JSON string representation of the Worker object.
     */
    @Override
    public String toJSONRecord() {
        return super.toJSONRecord().replace("}", ","
                + "\"hourlyPayRate\":" + hourlyPayRate
                + "}");
    }
}

