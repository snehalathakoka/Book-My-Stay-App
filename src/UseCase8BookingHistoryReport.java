import java.util.*;

class Booking {
    String guestName;
    String roomType;

    public Booking(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class UseCase8BookingHistoryReport {

    static List<Booking> bookingHistory = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting\n");

        // Simulating confirmed bookings
        bookingHistory.add(new Booking("Abhi", "Single"));
        bookingHistory.add(new Booking("Subha", "Double"));
        bookingHistory.add(new Booking("Vanmathi", "Suite"));

        generateReport();
    }

    public static void generateReport() {

        System.out.println("Booking History Report\n");

        for (Booking b : bookingHistory) {
            System.out.println("Guest: " + b.guestName + ", Room Type: " + b.roomType);
        }
    }
}