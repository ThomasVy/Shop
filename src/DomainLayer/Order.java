package DomainLayer;

import java.util.ArrayList;

import SharedElements.Document;
import SharedElements.User;

public class Order {
    private User buyer;
    private double amount;
    private ArrayList<Document> items;
    private String shippingAddress;
    private String dateOrdered;

    Order(User buyer) {
        this.buyer = buyer;
        items = new ArrayList<Document>();
        amount = 0;
    }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }
}
