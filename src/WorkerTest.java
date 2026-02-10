import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class WorkerTest {

    private Worker worker;

    @BeforeEach
    public void setUp() {
        worker = new Worker("W12345", "Daniel", "Guverra", "Mr.", 1980, 25.50);
    }

    @Test
    public void testSetter() {
        worker.setHourlyPayRate(30.00);
        assertEquals(30.00, worker.getHourlyPayRate(), "Hourly pay rate should be updated to 30.00");
    }

    @Test
    public void testCalculateWeeklyPayRegular() {
        double pay = worker.calculateWeeklyPay(40);
        assertEquals(1020.00, pay, "Weekly pay for 40 hours should be 1020.00");
    }

    @Test
    public void testCalculateWeeklyPayOvertime() {
        double pay = worker.calculateWeeklyPay(45);
        double expectedPay = (40 * 25.50) + (5 * 25.50 * 1.5);
        assertEquals(expectedPay, pay, "Weekly pay for 45 hours (including overtime) is incorrect");
    }

    // Had to use AI to help me on this since JUnit isn't made to test displays.

    @Test
    public void testDisplayWeeklyPay() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        worker.displayWeeklyPay(45);

        String expectedOutput = "Regular Hours: 40.0 x $25.5 = $1020.0\n" +
                "Overtime Hours: 5.0 x $38.25 = $191.25\n" +
                "Total Pay: $1211.25\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testToXML() {
        String expectedXML = "<Person><ID>W12345</ID><firstName>Daniel</firstName><lastName>Guverra</lastName><title>Mr." +
                "</title><YOB>1980</YOB><hourlyPayRate>25.5</hourlyPayRate></Person>";
        assertEquals(expectedXML, worker.toXML(), "XML output Guverras not match expected format.");
    }

    @Test
    public void testToJSONRecord() {
        String expectedJSON = "{\"IDNum\":\"W12345\",\"firstName\":\"Daniel\",\"lastName\":\"Guverra\",\"title\":\"Mr.\",\"YOB\":1980,\"hourlyPayRate\":25.5}";
        assertEquals(expectedJSON, worker.toJSONRecord(), "JSON output Guverras not match expected format.");
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "W12345,Daniel,Guverra,Mr.,1980,25.5";
        assertEquals(expectedCSV, worker.toCSV(), "CSV output Guverras not match expected format.");
    }
}

