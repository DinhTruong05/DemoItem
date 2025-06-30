package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Item> readDataFromFile(File myFile) throws IOException {
        List<Item> items = new ArrayList<>();
        if (myFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    if (data.length == 4) {
                        String id = data[0];
                        String name = data[1];
                        double price = Double.parseDouble(data[2]);
                        int quantity = Integer.parseInt(data[3]);
                        items.add(new Item(id, name, price, quantity));
                    }
                }
            }
        } else {
            throw new FileNotFoundException("File not found: " + myFile.getAbsolutePath());
        }
        return items;
    }

    public static void writeDataToFile(File myFile, List<Item> items) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(myFile))) {
            for (Item item : items) {
                String line = item.getId() + ";" + item.getName() + ";" + item.getPrice() + ";" + item.getQuantity();
                bw.write(line);
                bw.newLine();
            }
        }
    }
}
