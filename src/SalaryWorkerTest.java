import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class SalaryWorkerTest {

    private SalaryWorker salaryWorker;

    @BeforeEach
    public void setUp() {
        salaryWorker = new SalaryWorker("S12345", "Jackie", "Pham", "Dr.",
                1985, 30.00, 52000.00);
    }

    @Test
    public void testConstructorAndWeeklyPayCalculation() {
        double expectedWeeklyPay = 52000.0 / 52; // Should be 1000.0
        assertEquals(expectedWeeklyPay, salaryWorker.calculateWeeklyPay(40),
                "Weekly pay should be 52000 / 52 = 1000.0");
    }

    @Test
    public void testCalculateWeeklyPay() {
        double pay = salaryWorker.calculateWeeklyPay(40);  // Hours are not used in this case
        assertEquals(1000.00, pay, "Weekly pay for a salary of $52000 should be $1000.00");
    }

    @Test
    public void testDisplayWeeklyPay() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        salaryWorker.displayWeeklyPay(40);
        String expectedOutput = "Weekly Pay (as a fraction of annual salary): $1000.0\n";
        assertEquals(expectedOutput, outContent.toString(), "Printed output does not match expected weekly pay message.");
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "S12345,Jackie,Pham,Dr.,1985,30.0,52000.0";
        assertEquals(expectedCSV, salaryWorker.toCSV(), "CSV output does not match expected format.");
    }

    @Test
    public void testToXML() {
        String expectedXML = "<Person><ID>S12345</ID><firstName>Jackie</firstName><lastName>Pham</lastName><title>Dr." +
                "</title><YOB>1985</YOB><hourlyPayRate>30.0</hourlyPayRate><annualSalary>52000.0</annualSalary></Person>";
        assertEquals(expectedXML, salaryWorker.toXML(), "XML output does not match expected format.");
    }

    @Test
    public void testToJSONRecord() {
        String expectedJSON = "{\"IDNum\":\"S12345\",\"firstName\":\"Jackie\",\"lastName\":\"Pham\",\"title\":\"Dr.\"," +
                "\"YOB\":1985,\"hourlyPayRate\":30.0,\"annualSalary\":52000.0}";
        assertEquals(expectedJSON, salaryWorker.toJSONRecord(), "JSON output does not match expected format.");
    }
}
