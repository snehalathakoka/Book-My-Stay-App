import java.util.*;

public class UseCase6RoomAllocationService{

    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {


        rooms.add(new Room("Single Room", 1, 250, 1500.0, 2));
        rooms.add(new Room("Double Room", 2, 400, 2500.0, 1));
        rooms.add(new Room("Suite Room", 3, 750, 5000.0, 0));

        allocateRoom("Customer1", "Single Room");
        allocateRoom("Customer2", "Suite Room");
        allocateRoom("Customer3", "Double Room");

        displayRooms();
    }

    public static void allocateRoom(String customerName, String requiredType) {
        for (Room room : rooms) {
            if (room.type.equalsIgnoreCase(requiredType) && room.available > 0) {
                room.available--; // reduce available count
                System.out.println(customerName + " allocated " + room.type);
                return;
            }
        }
        System.out.println("No " + requiredType + " available for " + customerName);
    }

    public static void displayRooms() {
        System.out.println("\nUpdated Room Availability:\n");
        for (Room room : rooms) {
            System.out.println(room.type + " - Available: " + room.available);
        }
    }
}