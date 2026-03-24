import java.util.ArrayList;
import java.util.List;

class SearchRoom {
    String type;
    int beds;
    int size;
    double price;
    int available;

    public SearchRoom(String type, int beds, int size, double price, int available) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
        this.available = available;
    }

    public void displayResult() {
        System.out.println(type + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available: " + available + "\n");
    }
}

public class UseCase4RoomSearch {
    public static void main(String[] args) {
        System.out.println("Room Search\n");

        List<SearchRoom> results = new ArrayList<>();

        // Data exactly from your image
        results.add(new SearchRoom("Single Room", 1, 250, 1500.0, 5));
        results.add(new SearchRoom("Double Room", 2, 400, 2500.0, 3));
        results.add(new SearchRoom("Suite Room", 3, 750, 5000.0, 2));

        // Printing results in the requested format
        for (SearchRoom room : results) {
            room.displayResult();
        }
    }
}
