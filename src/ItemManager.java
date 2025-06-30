package src;

import src.entities.Item;
import src.exception.ItemNotFoundException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ItemManager {
    public static Scanner scanner = new Scanner(System.in);
    public static File myFile = new File("resource/products.txt");
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

    public static void searchItem() {
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

    public static void sortItem() throws IOException {
        while (true) {
            List<Item> items = FileManager.readDataFromFile(myFile);
            System.out.println(" Vui lòng chọn loại sắp xếp : ");
            System.out.println("1. Theo giá tăng dần ");
            System.out.println("2. Theo giá giảm dần ");
            System.out.println("0. Quay lại menu chính ");

            System.out.print("Enter your choice:");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                break;
            }

            switch (choice) {
                case "1":
                    for (int i = 0; i < items.size(); i++) {
                        for (int j = i + 1; j < items.size(); j++) {
                            if (items.get(i).getPrice() > items.get(j).getPrice()) {
                                Item temp = items.get(i);
                                items.set(i, items.get(j));
                                items.set(j, temp);
                            }
                        }
                    }
                    break;
                case "2":
                    for (int i = 0; i < items.size(); i++) {
                        for (int j = i + 1; j < items.size(); j++) {
                            if (items.get(i).getPrice() < items.get(j).getPrice()) {
                                Item temp = items.get(i);
                                items.set(i, items.get(j));
                                items.set(j, temp);
                            }
                        }
                    }
                    break;
                default:
                    System.out.println(" Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    continue;
            }

            for (Item item : items) {
                System.out.println(item);
            }
        }
    }
}


