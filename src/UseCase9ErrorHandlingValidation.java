import java.util.Scanner;

public class UseCase9ErrorHandlingValidation{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Booking Validation");

        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine().trim();

        if (guestName.isEmpty()) {
            System.out.println("Booking failed: Guest name cannot be empty.");
            return;
        }

        if (guestName.length() < 3) {
            System.out.println("Booking failed: Guest name must be at least 3 characters.");
            return;
        }

        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = scanner.nextLine().trim();

        if (!roomType.equalsIgnoreCase("Single") &&
                !roomType.equalsIgnoreCase("Double") &&
                !roomType.equalsIgnoreCase("Suite")) {
            System.out.println("Booking failed: Invalid room type selected.");
            return;
        }

        System.out.print("Enter number of nights: ");
        String nightsInput = scanner.nextLine().trim();

        int nights;
        try {
            nights = Integer.parseInt(nightsInput);
        } catch (NumberFormatException e) {
            System.out.println("Booking failed: Number of nights must be a valid number.");
            return;
        }

        if (nights <= 0) {
            System.out.println("Booking failed: Number of nights must be greater than 0.");
            return;
        }

        System.out.println("\nBooking Confirmed!");
        System.out.println("Guest   : " + guestName);
        System.out.println("Room    : " + roomType);
        System.out.println("Nights  : " + nights);
    }
}

