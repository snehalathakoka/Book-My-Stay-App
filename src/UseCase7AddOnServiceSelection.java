import java.util.*;

class AddOnService {
    String name;
    double price;

    public AddOnService(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {


        List<AddOnService> services = new ArrayList<>();
        services.add(new AddOnService("WiFi", 200));
        services.add(new AddOnService("Breakfast", 300));
        services.add(new AddOnService("Laundry", 150));


        List<AddOnService> selectedServices = new ArrayList<>();


        selectService("Customer1", "WiFi", services, selectedServices);
        selectService("Customer1", "Laundry", services, selectedServices);

        displayBill("Customer1", selectedServices);
    }

    public static void selectService(String customer, String serviceName,
                                     List<AddOnService> services,
                                     List<AddOnService> selectedServices) {

        for (AddOnService s : services) {
            if (s.name.equalsIgnoreCase(serviceName)) {
                selectedServices.add(s);
                System.out.println(serviceName + " added for " + customer);
                return;
            }
        }
        System.out.println(serviceName + " not available");
    }

    public static void displayBill(String customer, List<AddOnService> selectedServices) {
        double total = 0;

        System.out.println("\nAdd-On Services for " + customer + ":");

        for (AddOnService s : selectedServices) {
            System.out.println(s.name + " - " + s.price);
            total += s.price;
        }

        System.out.println("Total Add-On Cost: " + total);
    }
}