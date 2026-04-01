import java.io.*;
import java.util.*;

public class UseCase12DataPersistenceRecovery {

    static final String FILE_NAME = "inventory.txt";
    static Map<String, Integer> inventory = new LinkedHashMap<>();

    public static void main(String[] args) {

        System.out.println("System Recovery");

        loadInventory();

        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        saveInventory();
    }

    public static void loadInventory() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    inventory.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("No valid inventory data found. Starting fresh.");
            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
        }
    }

    public static void saveInventory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save inventory.");
        }
    }
}