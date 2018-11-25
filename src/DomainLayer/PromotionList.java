package DomainLayer;

import java.util.ArrayList;

import SharedElements.Document;
import SharedElements.RegisteredBuyer;

public class PromotionList {
    private ArrayList<Document> listOfPromotions;
    private ArrayList<RegisteredBuyer> listOfSubscribers;

    public PromotionList() {
        listOfPromotions = null;
        listOfSubscribers = null;
    }

    public ArrayList<Document> getListOfPromotions() { return listOfPromotions; }

    public void setListOfPromotions(ArrayList<Document> listOfPromotions) { this.listOfPromotions = listOfPromotions; }

    public ArrayList<RegisteredBuyer> getListOfSubscribers() { return listOfSubscribers; }

    public void setListOfSubscribers (ArrayList<RegisteredBuyer> listOfSubscribers) { this.listOfSubscribers = listOfSubscribers; }

}
