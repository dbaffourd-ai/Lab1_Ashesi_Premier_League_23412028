// PlayerSelection.java
import java.util.Scanner;

public class PlayerSelection {
    public static void main(String[] args) {
        final double POUND = 0.45359237;
        final int METER = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter height (in meters): ");
        double height = scanner.nextDouble();

        System.out.print("Enter weight (in pounds): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter jersey number: ");
        int jerseyNumber = scanner.nextInt();

        int weightKg = (int) (weight * POUND);
        int heightCm = (int) (height * METER);

        String category;
        if (age < 20) {
            category = "Rising Star";
        } else if (age <= 30) {
            category = "Prime Player";
        } else {
            category = "Veteran";
        }

        String position = switch (jerseyNumber) {
            case 1 -> "Goalkeeper";
            case 2, 5 -> "Defender";
            case 6, 8 -> "Midfielder";
            case 7, 11 -> "Winger";
            case 9 -> "Striker";
            case 10 -> "Playmaker";
            default -> "Player position not known";
        };

        boolean isAttacker = jerseyNumber == 7 || jerseyNumber == 9
                || jerseyNumber == 10 || jerseyNumber == 11;
        String attackerStatus = isAttacker ? "Yes" : "No";

        boolean eligible = age >= 18 && age <= 35 && weightKg < 90;
        String eligibilityStatus = eligible ? "Eligible" : "Not Eligible";

        String lineupDecision;
        if (category.equals("Prime Player")) {
            if (weightKg < 80) {
                lineupDecision = "Starting Lineup";
            } else {
                lineupDecision = "Bench";
            }
        } else {
            lineupDecision = "Bench";
        }

        String finalDecision = eligible ? "Play" : "Rest";

        System.out.println("\n    Player Report   ");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + heightCm + " cm");
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println("Jersey: " + jerseyNumber);
        System.out.println("Position: " + position);
        System.out.println("Attacker jersey: " + attackerStatus);
        System.out.println("Eligibility: " + eligibilityStatus);
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);

        System.out.print("\nUnwanted Fall-Through Demo\nEnter the jersey number: ");
        int demoJersey = scanner.nextInt();

        switch (demoJersey) {
            case 1:
                System.out.println("Player position: Goalkeeper");
                break;
            case 2:
            case 5:
                System.out.println("Player position: Defender");
                break;
            case 6:
            case 8:
                System.out.println("Player position: Midfielder");
                break;
            case 7:
            case 11:
                System.out.println("Player position: Winger");
                break;
            case 9:
                System.out.println("Player position: Striker");
                break;
            case 10:
                System.out.println("Player position: Playmaker");
                break;
            default:
                System.out.println("Player position not known");
        }

        scanner.close();
    }
}
