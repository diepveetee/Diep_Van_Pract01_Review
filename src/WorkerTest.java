import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {

    // Test 1: Constructor and Getter for hourlyPayRate
    @Test
    public void testConstructorAndGetter() {
        // Create a Worker object
        Worker worker = new Worker("W12345", "John", "Doe", "Mr.", 1980, 25.50);

        // Check if the hourlyPayRate is correctly set
        assertEquals(25.50, worker.getHourlyPayRate(), "Hourly pay rate should be 25.50");
    }

    // Test 2: Setter for hourlyPayRate
    @Test
    public void testSetter() {
        // Create a Worker object
        Worker worker = new Worker("W12345", "John", "Doe", "Mr.", 1980, 25.50);

        // Update the hourly pay rate
        worker.setHourlyPayRate(30.00);

        // Verify the updated pay rate
        assertEquals(30.00, worker.getHourlyPayRate(), "Hourly pay rate should be updated to 30.00");
    }

    // Test 3: calculateWeeklyPay() with 40 hours worked (no overtime)
    @Test
    public void testCalculateWeeklyPay_Regular() {
        // Create a Worker object
        Worker worker = new Worker("W12345", "John", "Doe", "Mr.", 1980, 25.50);

        // Calculate weekly pay for 40 hours (no overtime)
        double pay = worker.calculateWeeklyPay(40);

        // Verify that the calculated pay is correct
        assertEquals(1020.00, pay, "Weekly pay for 40 hours should be 1020.00");
    }

    // Test 4: calculateWeeklyPay() with overtime (more than 40 hours worked)
    @Test
    public void testCalculateWeeklyPay_Overtime() {
        // Create a Worker object
        Worker worker = new Worker("W12345", "John", "Doe", "Mr.", 1980, 25.50);

        // Calculate weekly pay for 45 hours (5 hours of overtime)
        double pay = worker.calculateWeeklyPay(45);

        // Expected pay: 40 hours at regular rate + 5 hours at 1.5x rate
        double expectedPay = (40 * 25.50) + (5 * 25.50 * 1.5);

        // Verify the pay is correct
        assertEquals(expectedPay, pay, "Weekly pay for 45 hours (including overtime) is incorrect");
    }

    // Test 5: displayWeeklyPay() - This would normally print, so we cannot easily test it programmatically
    // But you could use a mocking library like Mockito to capture System.out and test that way
}

