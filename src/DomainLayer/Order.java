package DomainLayer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import SharedElements.Document;
import SharedElements.User;

public class Order {
    private User buyer;
    private double amount;
    private ArrayList<Document> items;
    private String shippingAddress;
    private String dateOrdered;
    private static int orderId = 0;

    Order(User buyer, String shippingAddress) {
        this.buyer = buyer;
        items = new ArrayList<Document>();
        amount = 0;
        String pattern = "dd-MM-yyyy";
        this.shippingAddress = shippingAddress;
        dateOrdered = new SimpleDateFormat(pattern).format(new Date());
        orderId++;
    }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    public int getOrderId() { return orderId; }

    public String getShippingAddress() { return shippingAddress; }

    public String getDateOrdered() { return dateOrdered; }

    public User getBuyer() { return buyer; }

    public ArrayList<Document> getItems() { return items; }
}
