package DomainLayer;

import PresentationLayer.*;
import SharedElements.Document;
import SharedElements.Manager;
import SharedElements.OrdinaryBuyer;
import SharedElements.User;
import SharedElements.RegisteredBuyer;
import SharedElements.StaffMember;
import SharedElements.SystemAdmin;

import java.util.ArrayList;

public class OnlineSystem {
    private OnlineSystem instance;
    private UserInterface userInterface;
    private ArrayList<SystemAdmin> admins;
    private ArrayList<Manager> managers;
    private ArrayList<Order> orders;
    private PromotionList promotionList;
    private ArrayList<RegisteredBuyer> registeredBuyers;
    private ArrayList<StaffMember> staff;

    public User login (){ return new RegisteredBuyer();}

    public void placeOrder(Order order){}
    public Document searchForDocument(String query){return new Document();}
    public void registerOrdinaryBuyer(OrdinaryBuyer ordinaryBuyer){}
    public void unsubscribeRegisteredBuyer(RegisteredBuyer registeredBuyer){}
    public ArrayList<Document> getPromotionList(){return new ArrayList<Document>();}
    public void addDocument(Document document){}
    public void updateDocument(Document document){}
    public void removeDocument(Document document){}
    public ArrayList<Document> getDocumentList(){return new ArrayList<Document>();}
    public void submitForPrinting(Document document){}
    public void updateStaffMemberInfo(StaffMember staffMember){}
    public void startup(){}

}
