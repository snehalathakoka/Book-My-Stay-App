import java.util.*;
import java.util.concurrent.*;

class ConcurrentBookingProcessor implements Runnable {

    private Queue<String[]> bookingQueue;
    private Map<String, Integer> inventory;
    private List<String> allocationService;

    public ConcurrentBookingProcessor(Queue<String[]> bookingQueue,
                                      Map<String, Integer> inventory,
                                      List<String> allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public synchronized void run() {
        while (!bookingQueue.isEmpty()) {
            String[] booking = bookingQueue.poll();
            if (booking == null) return;

            String guest = booking[0];
            String roomType = booking[1];

            if (inventory.getOrDefault(roomType, 0) > 0) {
                inventory.put(roomType, inventory.get(roomType) - 1);
                int count = (int) allocationService.stream()
                        .filter(r -> r.startsWith(roomType)).count() + 1;
                String roomId = roomType + "-" + count;
                allocationService.add(roomId);
                System.out.println("Booking confirmed for Guest: " + guest + ", Room ID: " + roomId);
            } else {
                System.out.println("Booking failed for Guest: " + guest + ", No " + roomType + " available.");
            }
        }
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new LinkedHashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        Queue<String[]> bookingQueue = new LinkedList<>();
        bookingQueue.add(new String[]{"Abhi", "Single"});
        bookingQueue.add(new String[]{"Vanmathi", "Double"});
        bookingQueue.add(new String[]{"Kural", "Suite"});
        bookingQueue.add(new String[]{"Subha", "Single"});

        List<String> allocationService = new ArrayList<>();

        System.out.println("Concurrent Booking Simulation");

        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        System.out.println("\nRemaining Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
