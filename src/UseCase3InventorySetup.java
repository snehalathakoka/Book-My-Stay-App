import java.util.ArrayList;
import java.util.List;

class Room {
    String type;
    int beds;
    int size;
    double price;
    int available;

    public Room(String type, int beds, int size, double price, int available) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
        this.available = available;
    }

    public void displayStatus() {
        System.out.println(type + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available Rooms: " + available + "\n");
    }
}

public class UseCase3InventorySetup {
    public static void main(String[] args) {
        System.out.println("Hotel Room Inventory Status\n");

        List<Room> inventory = new ArrayList<>();

        // Setup inventory data
        inventory.add(new Room("Single Room", 1, 250, 1500.0, 5));
        inventory.add(new Room("Double Room", 2, 400, 2500.0, 3));
        inventory.add(new Room("Suite Room", 3, 750, 5000.0, 2));

        // Display the current status
        for (Room room : inventory) {
            room.displayStatus();
        }
    }
}
