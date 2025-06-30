import src.ItemManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemManager itemManager = new ItemManager();
        while (true) {
            System.out.println("Vui long chon Menu : ");
            System.out.println("1. Add Item");
            System.out.println("2. Show List Items");
            System.out.println("3. Search Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ItemManager.addItem();
                    break;
                case 2:
                    ItemManager.showListItems();
                    break;
                case 3:
                    itemManager.searchItem();
                    break;
                case 4:
                    ItemManager.deleteItem();
                    break;
                case 5:
                    System.exit(0);
            }
            if (choice == 5) {
                break;
            }

        }
    }
}