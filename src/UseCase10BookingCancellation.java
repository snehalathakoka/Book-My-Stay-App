import java.util.*;

public class UseCase10BookingCancellation {

    static Map<String, Integer> inventory = new HashMap<>();
    static List<String> rollbackHistory = new ArrayList<>();

    public static void main(String[] args) {

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        System.out.println("Booking Cancellation");

        cancelBooking("Single-1", "Single");
    }

    public static void cancelBooking(String reservationId, String roomType) {

        if (!inventory.containsKey(roomType)) {
            System.out.println("Cancellation failed: Invalid room type.");
            return;
        }

        inventory.put(roomType, inventory.get(roomType) + 1);
        rollbackHistory.add(0, "Released Reservation ID: " + reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);

        System.out.println("\nRollback History (Most Recent First):");
        for (String entry : rollbackHistory) {
            System.out.println(entry);
        }

        System.out.println("\nUpdated " + roomType + " Room Availability: " + inventory.get(roomType));
    }
}