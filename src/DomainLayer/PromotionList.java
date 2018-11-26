package DomainLayer;

import java.util.ArrayList;

import SharedElements.*;

public class PromotionList {
    private ArrayList<Document> listOfPromotions;
    private ArrayList<RegisteredBuyer> listOfSubscribers;

    public PromotionList() {
        listOfPromotions = null;
        listOfSubscribers = null;
    }

    public ArrayList<Document> getListOfPromotions() {
        return listOfPromotions;
    }

    public void setListOfPromotions(ArrayList<Document> listOfPromotions) {
        this.listOfPromotions = listOfPromotions;
    }

    public ArrayList<RegisteredBuyer> getListOfSubscribers() {
        return listOfSubscribers;
    }

    public void setListOfSubscribers(ArrayList<RegisteredBuyer> listOfSubscribers) {
        this.listOfSubscribers = listOfSubscribers;
    }

    public void addPromotion() {
        ArrayList<Author> authors3 = new ArrayList<Author>();
        authors3.add(new Author("J. K. Rowling"));
        listOfPromotions.add(new Document(3, "Harry Potter and the Philosopher's Stone", authors3, "June 26th 1997", "docx", 20, 9.65));
    }
}
