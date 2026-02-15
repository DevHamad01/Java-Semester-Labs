import java.util.Scanner;
public class DiscountCalculator {
    public static void main(String[] args) {
        // Constants
        final int UNIT_COST = 100;
        final double DISCOUNT_RATE = 0.1;
        final int DISCOUNT_THRESHOLD = 1000;

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for quantity
        System.out.print("Please Enter the quantity of items: ");
        int quantity = scanner.nextInt();

        // Calculate total cost
        int totalCost = quantity * UNIT_COST;
        if (totalCost > DISCOUNT_THRESHOLD) {
            // Apply discount
            double discountAmount = totalCost * DISCOUNT_RATE;
            totalCost -= discountAmount;
        }

        // Print total cost
        System.out.println("The Total cost: " + totalCost);

        // Close scanner
        scanner.close();
    }
}