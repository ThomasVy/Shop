package DomainLayer;

import java.util.ArrayList;

import SharedElements.Document;
import SharedElements.OrdinaryBuyer;

public class Order {
    private OrdinaryBuyer buyer;
    private double amount;
    private ArrayList<Document> items;
    private String shippingAddress;
    private String dateOrdered;
}
