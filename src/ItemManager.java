package src;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ItemManager {
    public static Scanner scanner = new Scanner(System.in);
    public static File myFile = new File("resource/products.txt");
//    static {
//        try {
//            File dir = new File("resource");
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            if (!myFile.exists()) {
//                myFile.createNewFile();
//            }
//        } catch (IOException e) {
//            System.err.println(" Could not create file or directory: " + e.getMessage());
//        }
//    }

    public static void showListItems() {
        try {
            List<Item> items = FileManager.readDataFromFile(myFile);
            for (Item item : items) {
                System.out.println(item);
            }
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }

    public static void addItem() {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập Giá : ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập Số lương : ");
        int quantity = Integer.parseInt(scanner.nextLine());

        try {
            List<Item> items = FileManager.readDataFromFile(myFile);
            items.add(new Item(id, name, price, quantity));
            FileManager.writeDataToFile(myFile, items);
            System.out.println(" Sản phẩm đã được thêm ! ");
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }

    public static void deleteItem() {
        System.out.print("Enter ID to delete: ");
        String id = scanner.nextLine();

        try {
            List<Item> items = FileManager.readDataFromFile(myFile);
            Item itemDelete = null;
            for (Item item : items) {
                if (item.getId().equalsIgnoreCase(id)) {
                    itemDelete = item;
                    break;
                }
            }

            if (itemDelete == null) {
                throw new ItemNotFoundException("Item with ID " + id + " not found.");
            }

            items.remove(itemDelete);
            FileManager.writeDataToFile(myFile, items);
            System.out.println("Sản phẩm đã được xóa");

        } catch (ItemNotFoundException e) {
            System.err.println("Error " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }

    public void searchItem() {
        System.out.print("Enter name or ID to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        try {
            List<Item> items = FileManager.readDataFromFile(myFile);
            boolean found = false;
            for (Item item : items) {
                if (item.getName().toLowerCase().contains(keyword) || item.getId().equalsIgnoreCase(keyword)) {
                    System.out.println(item);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Không tìm thấy sản phẩm ! ");
            }
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }
}
