package SharedElements;

import java.util.ArrayList;

import DomainLayer.Author;
import DomainLayer.Cover;

public class Document {
    private int documentId;
    private String name;
    private ArrayList<Author> authors;
    private String dateCreated;
    private Cover cover;
    private String type;
    private String content;
    private double price;
    private int availableAmount;

    public Document(int documentID, String name, ArrayList<Author> authors, double price, int availableAmount) {
        this.documentId = documentID;
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.availableAmount = availableAmount;
    }

    public String performUpload(){return new String();}

    public String getName() { return name; }

    public double getPrice() { return price; }

    public int getAvailableAmount() { return availableAmount; }

    public void setAvailableAmount(int availableAmount) { this.availableAmount = availableAmount; }

    public ArrayList<Author> getAuthors(){ return authors; }
}
