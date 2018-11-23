package DomainLayer;

import PresentationLayer.OrdinaryBuyer;

import java.util.ArrayList;

public class Order {
    private OrdinaryBuyer buyer;
    private double amount;
    private ArrayList<Document> items;
    private String shippingAddress;
    private String dateOrdered;
}
