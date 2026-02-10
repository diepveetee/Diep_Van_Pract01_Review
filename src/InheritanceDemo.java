import java.util.ArrayList;

public class InheritanceDemo {

    public static void main(String[] args) {
        // Create 3 Worker instances
        Worker worker1 = new Worker("W1001", "Van", "Deep", "Mr.", 2000, 16.00);
        Worker worker2 = new Worker("W1002", "Cosmin", "Fologea", "Dr.", 1989, 18.50);
        Worker worker3 = new Worker("W1003", "Bob", "Barley", "Mr.", 1960, 56.75);

        // Create 3 SalaryWorker instances
        SalaryWorker salaryWorker1 = new SalaryWorker("S1001", "Eve", "Beckham", "Dr.", 1980, 30.00, 60000.00);
        SalaryWorker salaryWorker2 = new SalaryWorker("S1002", "Frank", "Miller", "Dr.", 1978, 35.00, 70000.00);
        SalaryWorker salaryWorker3 = new SalaryWorker("S1003", "Chuck", "Norris", "Mr.", 1940, 40.00, 80000.00);

        // Add all workers and salary workers to an ArrayList<Worker>
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(salaryWorker1);
        workers.add(salaryWorker2);
        workers.add(salaryWorker3);

        // Simulate the 3 weekly pay periods
        System.out.printf("%-15s %-10s %-5s %-12s %-12s %-12s %-12s %-12s\n", "Name", "ID", "Title", "Week 1 Pay", "Week 2 Pay", "Week 3 Pay", "Total Pay", "Type");
        System.out.println("--------------------------------------------------------------------------------------------");

        for (Worker worker : workers) {
            // Calculate weekly pay for each week
            double week1Pay = worker.calculateWeeklyPay(40); // Week 1: 40 hours
            double week2Pay = worker.calculateWeeklyPay(50); // Week 2: 50 hours (overtime)
            double week3Pay = worker.calculateWeeklyPay(40); // Week 3: 40 hours again (normal)

            // Determine the type of worker (Salary or Hourly)
            String workerType;
            if (worker instanceof SalaryWorker) {
                workerType = "Salary";
            } else {
                workerType = "Hourly";
            }

            // Display the weekly pay for each worker
            System.out.printf("%-15s %-10s %-5s %-12.2f %-12.2f %-12.2f %-12.2f %-12s\n",
                    worker.getFirstName() + " " + worker.getLastName(),
                    worker.getIDNum(),
                    worker.getTitle(),
                    week1Pay,
                    week2Pay,
                    week3Pay,
                    week1Pay + week2Pay + week3Pay,
                    workerType);
        }
    }
}
