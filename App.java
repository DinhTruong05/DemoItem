import src.ItemManager;

import java.io.IOException;
import java.util.Scanner;

import static src.entities.Choice.*;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Chào mừng đến shop Main : ");
            System.out.println("1. Add Item");
            System.out.println("2. Show List Items");
            System.out.println("3. Show List Items from Binary");
            System.out.println("4. Search Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Sort Item by Price");


            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case ACTION_ADD:
                    ItemManager.addItem();
                    break;
                case ACTION_SHOW:
                    ItemManager.showListItems();
                    break;
                case ACTION_SHOWLISTBIN:
                    ItemManager.showListItemsFromBinary();
                    break;
                case ACTION_SEARCH:
                    ItemManager.searchItem();
                    break;
                case ACTION_DELETE:
                    ItemManager.deleteItem();
                    break;
                case ACTION_SORT:
                    ItemManager.sortItem();
                    break;

                default:
                    System.exit(ACTION_EXIT);
            }
        }
    }
}