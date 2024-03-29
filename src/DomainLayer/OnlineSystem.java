package DomainLayer;

import BackendLayer.*;
import PresentationLayer.*;
import SharedElements.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlineSystem {

    private static Scanner reader = new Scanner(System.in);
    private static User user;

    private static OnlineSystem instance;

    private CompanyDatabaseHelper cdh;
    private DocumentDatabaseHelper ddh;
    private UserDatabaseHelper udh;
    private CommandLineUI ui;

    private ArrayList<Observer> observers;
    private ArrayList<SystemAdmin> admins;
    private ArrayList<Manager> managers;
    private ArrayList<Order> orders;
    private PromotionList promotionList;
    private ArrayList<RegisteredBuyer> registeredBuyers;
    private ArrayList<StaffMember> staff;

    private OnlineSystem() {
    	observers = new ArrayList<Observer>();
        promotionList = new PromotionList();
        orders = new ArrayList<Order>();
        admins = new ArrayList<SystemAdmin>();
        managers = new ArrayList<Manager>();
        orders = new ArrayList<Order>();
        registeredBuyers = new ArrayList<RegisteredBuyer>();
        staff = new ArrayList<StaffMember>();
    }

    public void startup(CommandLineUI ui) {
        cdh = new CompanyDatabaseHelper();
        ddh = new DocumentDatabaseHelper();
        udh = new UserDatabaseHelper();

        ArrayList<User> cd = cdh.getCompanyDatabase();
        ArrayList<Document> dd = ddh.getDocumentDatabase();
        ArrayList<User> ud = udh.getUserDatabase();

        //just testing promotions list things
        promotionList.setListOfPromotions(dd);

        RegisteredBuyer rb1 = new RegisteredBuyer("d.yau", "password", "Douglas Yau", "d.yau@gmail.com");
        RegisteredBuyer rb2 = new RegisteredBuyer("e.ubalde", "password", "Errolle Ubalde", "e.ubalde@gmail.com");
        Manager m1 = new Manager("g.oblea", "password", "Gabriel Oblea", "g.oblea@gmail.com");
        Manager m2 = new Manager("g.gavieres", "password", "Gavin Gavieres", "g.gavieres@gmail.com");
        Operator o1 = new Operator("g.dagalea", "password", "Giuseppe Dagalea", "g.dagalea@gmail.com");
        Operator o2 = new Operator("r.lim", "password", "Rainer Lim", "r.lim@gmail.com");
        SystemAdmin sa1 = new SystemAdmin("s.schroh", "password", "Sebastian Schroh", "s.schroh", 1);
        SystemAdmin sa2 = new SystemAdmin("t.vy", "password", "Thomas Vy", "t.vy", 2);

        //just testing promotions list things
        promotionList.setListOfPromotions(dd);
        promotionList.setListOfSubscribers(new ArrayList<RegisteredBuyer>());

        promotionList.getListOfSubscribers().add(rb1);
        promotionList.getListOfSubscribers().add(rb2);

        ud.add(rb1);
        ud.add(rb2);
        ud.add(m1);
        ud.add(m2);
        ud.add(o1);
        ud.add(o2);
        ud.add(sa1);
        ud.add(sa2);

        this.ui = ui;
        registerObserver(ui);
        establishUser();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
        o.showNotification();
    }

    public void notifyAllObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).showNotification();
        }
    }

    public void establishUser() {
        ui.showStartingPage();
        orders = new ArrayList<Order>();
        // Check user input
        boolean done = false;
        while (!done) {
            try {
                int option = reader.nextInt();

                if (option == 1) {
                    reader.nextLine();
                    do {
                        user = login();
                    } while (user == null);
                    Class userCheck = user.getClass();
                    if (userCheck.getSimpleName().compareToIgnoreCase("RegisteredBuyer") == 0) {
                        ui.showRegisteredHomePage(user.name);
                        promptRegisteredBuyerForMenuInput();
                    } else if (userCheck.getSimpleName().compareToIgnoreCase("Operator") == 0) {
                        ui.showOperatorHomePage(user.name);
                        promptOperatorForMenuInput();

                    } else {
                    	ui.printMessage("ERROR:" +
                                userCheck.getSimpleName() +
                                " user type home page not implemented");
                    }
                    break;
                } else if (option == 2) {
                    user = new OrdinaryBuyer();
                    ui.showUnregisteredHomePage();
                    promptUnregisteredUserForMenuInput();
                    break;
                } else if (option == 3) {
                    System.exit(1);
                } else {
                	ui.printMessage("\nYour entry was not an option try again!");
                }
            } catch (InputMismatchException ex) {
            	ui.printMessage("Must be an integer value!");
                reader.nextLine();
            }
        }
    }

    private void promptOperatorForMenuInput() {
        int option;
        while (true)
            try {
                ui.showOperatorMenu();
                option = Integer.parseInt(reader.nextLine());
                if (option == 1) {
                	addDocument();
                } else if (option == 2) {
                   removeDocument();
                } else if (option == 3) {
                   updateDocument();
                } else if (option == 4) {
                    ui.demoCoverArt();
                } else if (option == 5) {
                	ui.printMessage("Have a nice day! Please comeback again");
                    establishUser();
                } else {
                	ui.printMessage("Your entry was not an option try again!");
                }
            } catch (InputMismatchException ex) {
            	ui.printMessage("Must be an integer value!");
                reader.nextLine();
            }

    }
    private void documentOptions(Document doc)
    {
    	while (true) {
          try {
        	  ui.showDocumentUpdateOptions(doc);
              int option = reader.nextInt();
              reader.nextLine();
              if (option == 1) {
            	  ui.printMessage("What would you like the document ID be?");
                  doc.setId(Integer.parseInt(reader.nextLine()));
              } else if (option == 2) {
            	  ui.printMessage("What would you like the document name be?");
                  doc.setName(reader.nextLine());
              } else if (option == 3) {
            	  ui.printMessage("What would you like the document date created be?");
                  doc.setDate(reader.nextLine());
              } else if (option == 4) {
            	  ui.printMessage("What would you like the document price be?");
                  doc.setPrice(Double.parseDouble(reader.nextLine()));
              } else if (option == 5) {
            	  ui.printMessage("What would you like the document quantity be?");
                  doc.setQuantity(Integer.parseInt(reader.nextLine()));
              } else if (option == 6) {
                  authorOptions(doc.getAuthors());
              } else if (option == 7) {
                  break;
              }
          } catch (InputMismatchException ex) {
        	  ui.printMessage("Must be an integer value!\n Please Try Again!");
          }
      }
    }
    private void authorOptions(ArrayList<Author> authors)
    {
    	int option;
        do {
            ui.showAuthorOptions();
            option = reader.nextInt();
            reader.nextLine();
            if (option == 1) {
            	ui.printMessage("Tell me the Author's name to Add");
                authors.add(new Author(reader.nextLine()));
            } else if (option == 2) {
            	ui.printMessage("Tell me the Author's name to Delete");
                String input = reader.nextLine();
                for (int i = 0; i < authors.size(); i++) {
                    if (authors.get(i).getName().equalsIgnoreCase(input)) {
                        authors.remove(i);
                        break;
                    }
                }
            }
        } while (option != 3);

    }
    public void promptUnregisteredUserForMenuInput() {
        int option;
        while (true)
            try {
                ui.showUnregisteredMenu();
                option = reader.nextInt();
                if (option == 1) {
                    reader.nextLine();
                    ui.showBookSearchPage();
                    String document = reader.nextLine();
                    ui.showBookFound(searchForDocument(document));
                } else if (option == 2) {
                    reader.nextLine();
                    ui.showOrderPlacementPage();
                    composeOrder();
                } else if (option == 3) {
                    ui.showMakePaymentPage();
                    makePayment();
                } else if (option == 4) {
                    ui.showRegistrationPage();
                    registerUser();
                } else if (option == 5) {
                    ui.demoCoverArt();
                } else if (option == 6) {
                	ui.printMessage("Thanks for coming!");
                    establishUser();
                }

            } catch (InputMismatchException ex) {
            	ui.printMessage("Must be an integer value!");
                reader.nextLine();
            }
    }

    public void promptRegisteredBuyerForMenuInput() {
        int option;
        while (true) {
            try {
                ui.showRegisteredMenu(((RegisteredBuyer)user).getSubscription());
                option = reader.nextInt();
                if (option == 1) {
                    reader.nextLine();
                    ui.showBookSearchPage();
                    String document = reader.nextLine();
                    ui.showBookFound(searchForDocument(document));
                } else if (option == 2) {
                    reader.nextLine();
                    ui.showOrderPlacementPage();
                    composeOrder();
                } else if (option == 3) {
                    ui.showMakePaymentPage();
                    makePayment();
                } else if (option == 4) {
                    if (promotionList.getListOfSubscribers().contains(user))
                        ui.showPromotionsListPage(promotionList.getListOfPromotions());
                    else
                    	ui.printMessage("Sorry you unsubscribed from the promotions list!");
                } else if (option == 5 && ((RegisteredBuyer) user).getSubscription()) {
                    ui.showUnsubscribePage();
                    unsubscribeRegisteredBuyer((RegisteredBuyer) user);
                } else if (option == 5 && !((RegisteredBuyer)user).getSubscription()) {
                    ui.showResubscribePage();
                    resubscribeRegisteredBuyer((RegisteredBuyer)user);

                }
                else if (option == 6) {
                    ui.demoCoverArt();
                } else if (option == 7) {
                    promotionList.addPromotion();
                    notifyAllObservers();
                } else if (option == 8) {
                	ui.printMessage("\nHave a nice day! Please comeback again");
                    establishUser();
                } else {
                	ui.printMessage("Your entry was not an option try again!");
                }
            } catch (InputMismatchException ex) {
            	ui.printMessage("Must be an integer value!");
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
    	ui.printMessage("Please type in your username");
        String username = reader.nextLine();
        ui.printMessage("Please type in your password");
        String password = reader.nextLine();
        return udh.verifyUser(username, password);
    }

    public void registerUser() {
        ui.printMessage("Enter your username");
        reader.nextLine();
        String username = reader.nextLine();
        ui.printMessage("Enter your password");
        String password = reader.nextLine();
        ui.printMessage("Enter your name");
        String name = reader.nextLine();
        ui.printMessage("Enter your email");
        String email = reader.nextLine();
        RegisteredBuyer rb = new RegisteredBuyer(username, password, name, email);
        udh.insert(rb);
        promotionList.getListOfSubscribers().add(rb);
        establishUser();
    }

    public void composeOrder() {
        ui.printMessage("Please enter your address");
        String address = reader.nextLine();
        Order theOrder = new Order(user, address);
        boolean orderComplete = false;
        boolean orderCancelled = false;
        int option;
        while(true) {
        	ui.showComposeOrderMenu();
            String integer = reader.nextLine();
            if(integer.compareTo("1") == 0) {
                break;
            }
            else if(integer.compareTo("2") == 0) {
                ui.displayAllDocuments(ddh.getDocumentDatabase());
            }
            else if(integer.compareTo("3") == 0) {
                return;
            }
            else {
                ui.printMessage("Your entry is not an option");
            }

        }
        while (!orderComplete && !orderCancelled) {
            ui.printMessage("Enter the book you'd like to order");
            String query = reader.nextLine();
            Document document = searchForDocument(query);
            // if document doesn't exist print an error
            if (document == null) {
                ui.printMessage("No book with that name found! SORRY!");
            }
            // if document exists continue
            else {
                // if document is out of stock print an error
                if (document.getAvailableAmount() == 0) {
                    ui.printMessage("Sorry we are out of stock!");
                }
                // else if document is in stock show it and add it to the order
                else {
                    ui.showBookFound(document);
                    theOrder.setAmount(theOrder.getAmount() + document.getPrice());
                    document.takeAwayQuantity();
                    theOrder.getItems().add(document);
                    while (true) {
                        try {
                            // prompt the user if they'd like to add more to the order
                            ui.showMoreOrderOptions();
                            option = reader.nextInt();
                            // if yes then prompt break loop and clear scanner
                            if (option == 1) {
                                reader.nextLine();
                                break;
                            }
                            // if not then set order as complete place it and show the receipt
                            else if (option == 2) {
                                orderComplete = true;
                                placeOrder(theOrder);
                                ui.showFinalOrder(theOrder);
                                reader.nextLine();
                                break;
                            }
                            else if (option == 3) {
                                ui.displayAllDocuments(ddh.getDocumentDatabase());
                            }
                            else if(option == 4) {
                                orderCancelled = true;
                            }
                            else {
                                ui.printMessage("Your entry was not an option try again!");
                            }
                        } catch (InputMismatchException ex2) {
                            ui.printMessage("Must be an integer value!");
                            reader.nextLine();
                        }
                        if(orderCancelled) {
                            for(Document doc: theOrder.getItems()) {
                                doc.setAvailableAmount(doc.getAvailableAmount() + doc.getQuantitySetAside());
                                doc.setQuantitySetAside(0);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public Document searchForDocument(String query) {
        ArrayList<Document> documents = ddh.getDocumentDatabase();
        if (documents == null) {
            ui.printMessage("ERROR: Database fatal error");
        } else {
            for (Document doc : documents) {
                if (doc.getName().compareToIgnoreCase(query) == 0) {
                    return doc;
                }
            }
        }

        return null;
    }

    public void makePayment() {
        double amountOwed = 0;
        for (Order order : orders) {
            // just here when we implement multi users using at same time
//            if (order.getBuyer().getUsername().compareTo(user.getUsername()) == 0) ;
//            {
//                for (Document docs : order.getItems()) {
//                    amountOwed += docs.getPrice();
//                }
//            }
            for (Document docs : order.getItems()) {
                amountOwed += docs.getPrice();
            }
        }
        ui.printMessage("You owe $" + amountOwed +
                "\nPlease type in your credit card number: ");
        String cardNumber = reader.nextLine();
        reader.nextLine();
        ui.printMessage("Thank you for your payment have a nice day!");
    }

    public void registerOrdinaryBuyer(OrdinaryBuyer ordinaryBuyer) {

    }

    public void resubscribeRegisteredBuyer(RegisteredBuyer registeredBuyer) {
        int option;
        ui.showConfirmationRMenu();
        while (true) {
            try {
                option = reader.nextInt();
                if (option == 1) {
                    ui.printMessage("You have sucessfully resubscirbed! (we love you :] )");
                    promotionList.getListOfSubscribers().add(registeredBuyer);
                    registeredBuyer.setSubscription(true);
                    break;
                } else if (option == 2) {
                    ui.printMessage("You are staying unsubscribed, we hope you'll reconsider :(");
                    break;
                } else {
                    ui.printMessage("You selected an option not available!");
                }
            } catch (InputMismatchException ex) {
                reader.nextLine();
                ui.printMessage("Must be an integer value!");
            }
        }
    }

    public void unsubscribeRegisteredBuyer(RegisteredBuyer registeredBuyer) {
        int option;
        ui.showConfirmationUMenu();
        while (true) {
            try {
                option = reader.nextInt();
                if (option == 1) {
                    ui.printMessage("You have sucessfully unsubscirbed! (we'll miss you :[ )");
                    promotionList.getListOfSubscribers().remove(registeredBuyer);
                    registeredBuyer.setSubscription(false);
                    break;
                } else if (option == 2) {
                    ui.printMessage("Thanks for staying subscribed, we'll make sure to bring the best deals!");
                    break;
                } else {
                    ui.printMessage("You selected an option not available!");
                }
            } catch (InputMismatchException ex) {
                reader.nextLine();
                ui.printMessage("Must be an integer value!");
            }
        }
    }


    private void addDocument()
    {
    	ui.printMessage("Please enter the document type:");
    	String type = reader.nextLine();
    	while(!type.equalsIgnoreCase("PDF")&&!type.equalsIgnoreCase("DOCX")&&!type.equalsIgnoreCase("PNG"))
    	{
    		ui.printMessage("Please enter a valid type");
    		type = reader.nextLine();
    	}
    	int id = -1;
    	while(id<0)
    	{
        	ui.printMessage("Enter the document Id (must be greater than 0):");
        	id = Integer.parseInt(reader.nextLine());
    	}
    	ui.printMessage("Enter the book name:");
    	String name = reader.nextLine();
        ArrayList<Author> authors = new ArrayList<Author>();
		authorOptions(authors);
    	ui.printMessage("Enter the date the document was created:");
    	String date =  reader.nextLine();
    	ui.printMessage("Enter the price of the document:");
    	double price =  Double.parseDouble(reader.nextLine());
    	ui.printMessage("Enter the quantity of the document available:");
    	int quantity = Integer.parseInt(reader.nextLine());
    	Document doc = new Document(id, name, authors, date, type , quantity, price);
    	if(doc.performUpload())
    	{
        	ddh.insert(doc);
        	ui.printMessage("Successful addition of document!");
    	}
    	else
    		ui.printMessage("Failed to upload document!");
    	
    }
    private void removeDocument()
    {
    	 ui.showRemoveDocumentPage(ddh.getDocumentDatabase());
         if (ddh.getDocumentDatabase().size() == 0) {
             ui.printMessage("Sorry! There are no documents available.");
             return;
         }
         int removalIndex;
         while (true) {
             try {
                 removalIndex = Integer.parseInt(reader.nextLine());
                 if (removalIndex >= 0 && removalIndex < ddh.getDocumentDatabase().size())
                     break;
             } catch (InputMismatchException e) {
                 ui.printMessage("Must be an integer value");
             }
             ui.printMessage("Please try again");
         }
         removeDocument(removalIndex);
    }
    private void updateDocument ()
    {
    	  ui.showUpdateDocumentPage(ddh.getDocumentDatabase());
          int updateIndex;
          while (true) {
              try {
                  updateIndex = Integer.parseInt(reader.nextLine());
                  if (updateIndex >= 0 && updateIndex < ddh.getDocumentDatabase().size())
                      break;
              } catch (InputMismatchException e) {
                  ui.printMessage("Must be an integer value");
              }
              ui.printMessage("Please try again");
          }
         documentOptions(ddh.getDocumentDatabase().get(updateIndex));
          
    }
    public ArrayList<Document> getPromotionList() {
        return new ArrayList<Document>();
    }

    public void addDocument(Document document) {
        if (document.performUpload()) {
            ddh.getDocumentDatabase().add(document);
        } else
            ui.printMessage("Could not perform upload");
    }

    public void updateDocument(Document document) {

    }

    public void removeDocument(int index) {
        ddh.getDocumentDatabase().remove(index);
    }

    public ArrayList<Document> getDocumentList() {
        return ddh.getDocumentDatabase();
    }

    public void submitForPrinting(Document document) {

    }

    public void updateStaffMemberInfo(StaffMember staffMember) {

    }
    
    

}
