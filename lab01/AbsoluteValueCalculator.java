import java.util.Scanner;
public class AbsoluteValueCalculator {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate absolute value
        int absoluteValue = Math.abs(number);

        // Print absolute value
        System.out.println("Absolute value: " + absoluteValue);

        // Close scanner
        scanner.close();
    }
}