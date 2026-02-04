import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner input = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals
        // -------------------------------------------------------------
        System.out.println("Welcome to the Weekly Sleep Tracker!");
        System.out.println("This program analyzes your sleep over 7 days.");
        System.out.print("How many hours of sleep is your nightly goal? ");
        double sleepGoal = input.nextDouble();

        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        // -------------------------------------------------------------
        double[] weekData = new double[7];

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day
        //         Include input validation
        // -------------------------------------------------------------
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter hours slept for day " + (i + 1) + ": ");
            double hours = input.nextDouble();

            while (hours < 0 || hours > 24) {
                System.out.print("Invalid input. Enter a value between 0 and 24: ");
                hours = input.nextDouble();
            }

            weekData[i] = hours;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        // -------------------------------------------------------------
        WeeklyData sleepWeek = new WeeklyData(weekData);

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        // -------------------------------------------------------------
        System.out.println("\n--- Weekly Sleep Analysis ---");
        System.out.printf("Total hours slept: %.2f%n", sleepWeek.getTotal());
        System.out.printf("Average hours per night: %.2f%n", sleepWeek.getAverage());
        System.out.printf("Least sleep in one night: %.2f hours%n", sleepWeek.getMin());
        System.out.printf("Most sleep in one night: %.2f hours%n", sleepWeek.getMax());

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        // -------------------------------------------------------------
        System.out.println("\n--- Daily Sleep Data ---");
        System.out.println(sleepWeek);

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        // -------------------------------------------------------------
        System.out.println("\n--- Sleep Insight ---");
        if (sleepWeek.getAverage() < sleepGoal) {
            System.out.println("You are not getting enough sleep on average.");
            System.out.println("Try going to bed earlier next week!");
        } else {
            System.out.println("Great job! You are meeting your sleep goal!");
            System.out.println("Keep up the healthy sleep average!");
        }

        input.close();
    }
}
