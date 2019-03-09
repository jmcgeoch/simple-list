package edu.monmouth.jzemartis.firebaseauthmenu;

/**
 * Created by jessica on 3/30/18.
 */

public class Product {

    public String name;
    public int quantity;

    public Product() {
        this.name = "";
        this.quantity = 0;
    }

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
