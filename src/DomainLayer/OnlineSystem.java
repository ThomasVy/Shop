package DomainLayer;

import PresentationLayer.*;

import java.util.ArrayList;

public class OnlineSystem {
    private OnlineSystem instance;
    private UserInterface userInterface;
    private ArrayList<SystemAdmin> admins;
    private ArrayList<Manager> managers;
    private ArrayList<Order> orders;
    private PromotionList promotionList;
    private ArrayList<RegisterBuyer> registeredBuyers;
    private ArrayList<StaffMember> staff;

    public User login (){ return new RegisterBuyer();}
    public void placeOrder(Order order){}
    public Document searchForDocument(String query){return new Document();}
    public void registerOrdinaryBuyer(OrdinaryBuyer ordinaryBuyer){}
    public void unsubscribeRegisteredBuyer(RegisterBuyer registeredBuyer){}
    public ArrayList<Document> getPromotionList(){return new ArrayList<Document>();}
    public void addDocument(Document document){}
    public void updateDocument(Document document){}
    public void removeDocument(Document document){}
    public ArrayList<Document> getDocumentList(){return new ArrayList<Document>();}
    public void submitForPrinting(Document document){}
    public void updateStaffMemberInfo(StaffMember staffMember){}
    public void startup(){}

}
