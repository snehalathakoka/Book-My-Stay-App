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

    public void displayInfo() {
        System.out.println(type + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available: " + available);
        System.out.println();
    }
}

public class UseCase2RoomInitialization {
    public static void main(String[] args) {
        System.out.println("Hotel Room Initialization\n");

        List<Room> rooms = new ArrayList<>();


        rooms.add(new Room("Single Room", 1, 250, 1500.0, 5));
        rooms.add(new Room("Double Room", 2, 400, 2500.0, 3));
        rooms.add(new Room("Suite Room", 3, 750, 5000.0, 2));


        for (Room room : rooms) {
            room.displayInfo();
        }
    }
}
