import java.util.LinkedList;
import java.util.Queue;

class BookingRequest {
    String guestName;
    String roomType;

    public BookingRequest(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class UseCase5BookingQueue {
    public static void main(String[] args) {
        System.out.println("Booking Request Queue");

        Queue<BookingRequest> queue = new LinkedList<>();

        queue.add(new BookingRequest("Abhi", "Single"));
        queue.add(new BookingRequest("Subha", "Double"));
        queue.add(new BookingRequest("Vanmathi", "Suite"));

        while (!queue.isEmpty()) {
            BookingRequest request = queue.poll();
            System.out.println("Processing booking for Guest: " + request.guestName +
                    ", Room Type: " + request.roomType);
        }
    }
}
