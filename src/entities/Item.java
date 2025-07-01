package src.entities;

import java.io.Serial;
import java.io.Serializable;

public class Item implements Serializable {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Item {" +
                "id=" + id +
                ", Tên sản phẩm='" + name + '\'' +
                ", Giá =" + price +
                ", Số Lượng ='" + quantity + '\'' +
                '}';
    }
}

