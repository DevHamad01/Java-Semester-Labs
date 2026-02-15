import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for marks
        System.out.print("Enter marks: ");
        int marks = scanner.nextInt();

        // Calculate grade based on marks
        char grade;
        if (marks < 25) {
            grade = 'F';
        } else if (marks >= 25 && marks < 45) {
            grade = 'E';
        } else if (marks >= 45 && marks < 50) {
            grade = 'D';
        } else if (marks >= 50 && marks < 60) {
            grade = 'C';
        } else if (marks >= 60 && marks < 80) {
            grade = 'B';
        } else {
            grade = 'A';
        }

        // Print grade
        System.out.println("Grade: " + grade);

        // Close scanner
        scanner.close();
    }
}