import java.util.Scanner;

public class RectangleChecker {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for length and breadth
        System.out.print(" Please Enter length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Please Enter breadth of the rectangle: ");
        double breadth = scanner.nextDouble();

        // Check if it's a square or not
        if (length == breadth) {
            System.out.println("Yes,It's a square.");
        } else {
            System.out.println("No,It's not a square.");
        }

        // Close scanner
        scanner.close();
    }
}