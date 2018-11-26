package DomainLayer;

import BackendLayer.*;
import PresentationLayer.*;
import SharedElements.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlineSystem {
    private static Scanner reader = new Scanner(System.in);
    private static int userType;
    private static User user;

    private static OnlineSystem instance;

    private CompanyDatabaseHelper cdh;
    private DocumentDatabaseHelper ddh;
    private UserDatabaseHelper udh;
    private CommandLineUI ui;

    private ArrayList<SystemAdmin> admins;
    private ArrayList<Manager> managers;
    private ArrayList<Order> orders;
    private PromotionList promotionList;
    private ArrayList<RegisteredBuyer> registeredBuyers;
    private ArrayList<StaffMember> staff;
    private ArrayList<Document> documents;

    private OnlineSystem() {
    }

    public void startup(CommandLineUI ui) {
        cdh = new CompanyDatabaseHelper();
        ddh = new DocumentDatabaseHelper();
        udh = new UserDatabaseHelper();

        ArrayList<User> cd = cdh.getCompanyDatabase();
        ArrayList<Document> dd = ddh.getDocumentDatabase();
        ArrayList<User> ud = udh.getUserDatabase();

        RegisteredBuyer rb1 = new RegisteredBuyer("d.yau", "password", "Douglas Yau", "d.yau@gmail.com");
        RegisteredBuyer rb2 = new RegisteredBuyer("e.ubalde", "password", "Errolle Ubalde", "e.ubalde@gmail.com");
        Manager m1 = new Manager("g.oblea", "password", "Gabriel Oblea", "g.oblea@gmail.com");
        Manager m2 = new Manager("g.gavieres", "password", "Gavin Gavieres", "g.gavieres@gmail.com");
        Operator o1 = new Operator("g.dagalea", "password", "Giuseppe Dagalea", "g.dagalea@gmail.com");
        Operator o2 = new Operator("r.lim", "password", "Rainer Lim", "r.lim@gmail.com");
        SystemAdmin sa1 = new SystemAdmin("s.schroh", "password", "Sebastian Schroh", "s.schroh", 1);
        SystemAdmin sa2 = new SystemAdmin("t.vy", "password", "Thomas Vy", "t.vy", 2);

        ud.add(rb1);
        ud.add(rb2);
        ud.add(m1);
        ud.add(m2);
        ud.add(o1);
        ud.add(o2);
        ud.add(sa1);
        ud.add(sa2);

        this.ui = ui;
        establishUser();
    }

    public void establishUser() {
        ui.showStartingPage();
        // Check user input
        boolean done = false;
        while (!done) {
            try {
                int option = reader.nextInt();

                if (option == 1) {
                    reader.nextLine();
                    do {
                    	user = login();
                    }while(user == null);
                    Class userCheck = user.getClass();
                    if (userCheck.getSimpleName().compareToIgnoreCase("RegisteredBuyer") == 0) {
                        ui.showRegisteredHomePage(user.name);
                        promptRegisteredBuyerForMenuInput();
                    }
                    else if (userCheck.getSimpleName().compareToIgnoreCase("Operator") == 0) {
                        ui.showOperatorHomePage(user.name);
                        promptOperatorForMenuInput();

                    }
                    else{
                        System.out.println("ERROR:" +
                                userCheck.getSimpleName() +
                                " user type home page not implemented");
                    }
                    break;
                } else if (option == 2) {
                    userType = 3;
                    ui.showUnregisteredHomePage();
                    promptUnregisteredUserForMenuInput();
                    break;
                } else {
                    System.out.println("\nYour entry was not an option try again!");
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Must be an integer value!");
                reader.nextLine();
            }
        }
    }
    private void promptOperatorForMenuInput() {
        int option;
        while(true)
            try {
                ui.showOperatorMenu();
                option = reader.nextInt();
                if(option == 1) {
                    addDocument(ui.showSubmitDocumentPage());
                }
                else if (option == 2) {
                    ui.showRemoveDocumentPage();
                }
                else if (option == 3) {
                    ui.showUpdateDocumentPage();
                }
                else if (option == 4) {
                    ui.demoCoverArt();
                }
                else if (option == 5) {
                    System.out.println("Have a nice day! Please comeback again");
                    System.exit(1);
                }
                else {
                    System.out.println("Your entry was not an option try again!");
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Must be an integer value!");
                reader.nextLine();
            }

    }

    public void promptUnregisteredUserForMenuInput() {
        int option;
        while(true)
            try {
                ui.showUnregisteredMenu();
                option = reader.nextInt();
                if(option == 1) {
                    ui.showBookSearchPage();
                }
                else if (option == 2) {
                    ui.showOrderPlacementPage();
                }
                else if (option == 3) {
                    ui.showMakePaymentPage();
                }
                else if (option == 4) {
                    ui.showRegistrationPage();
                }
                else if(option == 5){
                    ui.demoCoverArt();
                }
                else if(option == 6){
                    System.out.println("Thanks for coming!");
                    System.exit(1);
                }

            }
            catch (InputMismatchException ex) {
                System.out.println("Must be an integer value!");
                reader.nextLine();
            }
    }

    public void promptRegisteredBuyerForMenuInput() {
        int option;
        while(true) {
            try {
                ui.showRegisteredMenu();
                option = reader.nextInt();
                if (option == 1) {
                    ui.showBookSearchPage();
                }
                else if (option == 2) {
                    ui.showOrderPlacementPage();
                }
                else if (option == 3) {
                    ui.showMakePaymentPage();
                }

                else if (option == 4) {
                    ui.showPromotionListPage();
                }

                else if (option == 5) {
                    ui.showUnsubscribePage();
                }
                else if (option == 6) {
                    ui.demoCoverArt();
                }
                else if (option == 7) {
                    System.out.println("\nHave a nice day! Please comeback again");
                    System.exit(1);
                }
                else {
                    System.out.println("Your entry was not an option try again!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Must be an integer value!");
                reader.nextLine();
            }
        }
    }


    public static OnlineSystem getInstance() {
        if (instance == null) {
            instance = new OnlineSystem();
        }
        return instance;
    }

    public User login() {
        System.out.println("Please type in your username");
        String username = reader.nextLine();
        System.out.println("Please type in your password");
        String password = reader.nextLine();
        return udh.verifyUser(username, password);
    }

    public void placeOrder(Order order) {

    }

    public void searchForDocument(String query) {
    }

    public void registerOrdinaryBuyer(OrdinaryBuyer ordinaryBuyer) {

    }

    public void unsubscribeRegisteredBuyer(RegisteredBuyer registeredBuyer) {

    }

    public ArrayList<Document> getPromotionList() {
        return new ArrayList<Document>();
    }

    public void addDocument(Document document) {
    	if (document.performUpload())
    	{
    		System.out.println("Succ");
    		ddh.getDocumentDatabase().add(document);
    	}
    }

    public void updateDocument(Document document) {

    }

    public void removeDocument(Document document) {

    }

    public ArrayList<Document> getDocumentList() {
        return ddh.getDocumentDatabase();
    }

    public void submitForPrinting(Document document) {

    }

    public void updateStaffMemberInfo(StaffMember staffMember) {

    }

}
