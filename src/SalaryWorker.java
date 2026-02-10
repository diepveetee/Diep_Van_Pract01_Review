public class SalaryWorker extends Worker {
    private double annualSalary;

    /**
     * Constructor to initialize a SalaryWorker object with necessary fields.
     * Calls the parent (Worker) constructor using super().
     *
     * @param IDNum The unique ID number for the worker.
     * @param firstName The first name of the worker.
     * @param lastName The last name of the worker.
     * @param title The title (e.g., Mr., Mrs., Dr.) of the worker.
     * @param YOB The year of birth of the worker.
     * @param hourlyPayRate The hourly pay rate of the worker.
     * @param annualSalary The annual salary of the worker.
     */
    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(IDNum, firstName, lastName, title, YOB, hourlyPayRate);  // Call the parent (Worker) constructor
        this.annualSalary = annualSalary;
    }

    /**
     * Calculates the weekly pay for the SalaryWorker.
     * Divides the annual salary by 52 to get the weekly pay.
     *
     * @param hoursWorked The number of hours worked in a week (not used here but retained for polymorphism).
     * @return The total weekly pay.
     */
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;  // Weekly pay is annual salary divided by 52
    }

    /**
     * Displays the weekly pay, indicating it's a fraction of the annual salary.
     *
     * @param hoursWorked The number of hours worked in a week (not used here but retained for polymorphism).
     */
    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.println("Weekly Pay (as a fraction of annual salary): $" + weeklyPay);
    }

    /**
     * Converts the SalaryWorker object to a CSV (Comma Separated Values) string representation.
     * Includes the new field annualSalary.
     *
     * @return A CSV string representation of the SalaryWorker object.
     */
    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    /**
     * Converts the SalaryWorker object to an XML string representation.
     * Includes the new field annualSalary.
     *
     * @return A string representing the SalaryWorker object in XML format.
     */
    @Override
    public String toXML() {
        return super.toXML().replace("</Person>", "")
                + "<annualSalary>" + annualSalary + "</annualSalary>"
                + "</Person>";
    }

    /**
     * Converts the SalaryWorker object to a JSON string representation.
     * Includes the new field annualSalary.
     *
     * @return A JSON string representation of the SalaryWorker object.
     */
    @Override
    public String toJSONRecord() {
        return super.toJSONRecord().replace("}", ","
                + "\"annualSalary\":" + annualSalary
                + "}");
    }
}
