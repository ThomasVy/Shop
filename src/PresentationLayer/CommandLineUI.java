package PresentationLayer;

import DomainLayer.*;

import SharedElements.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineUI implements UserInterface {

    static Scanner reader = new Scanner(System.in);

    // userType == 1 -> user is an Operator
    // userType == 2 -> user is a Register Buyer
    // userType == 3 -> user is an Unregistered Buyer
    // this can be swapped with static User type when everything else is implemented
    // just check what type of user they are after
    static int userType;

    static String username;

    public CommandLineUI() {
    }

    @Override
    public void showStartingPage() {
        // Displaying some dialogue for easy user interaction
        System.out.println(
                "\nWelcome to BIG BOOK ENERGY.inc" +
                "\nWould you like to enter as a registered user or operator, or enter to just shop?" +
                "\nJust so you know registered users get access to exclusive deals!" +
                "\n1. I'd like to login" +
                "\n2. Continue as unregistered"
        );
    }

    @Override
    public void showUnregisteredHomePage() {
            System.out.println(
                    "\nWelcome to BIG BOOK ENERGY.inc!"
            );
    }

    public void showUnregisteredMenu(){

        System.out.println(
                "\nPlease select from the following options!" +
                        "\n1. Search for a book" +
                        "\n2. Place an order" +
                        "\n3. Make a payment" +
                        "\n4. Register" +
                        "\n5. Demo cover art" +
                        "\n6. Exit"
        );
    }

    @Override
    public void showRegisteredHomePage(String username) {
    	this.username = username; 
        System.out.println(
                        "\nWelcome " + username + " to BIG BOOK ENERGY.inc!"
        );
    }

    public void showRegisteredMenu() {
        System.out.println(
                "\nPlease select from the following options!" +
                        "\n1. Search for a book" +
                        "\n2. Place an order" +
                        "\n3. Make a payment" +
                        "\n4. See promotions List" +
                        "\n5. Unsubscribe from promotions list" +
                        "\n6. Demo cover art" +
                        "\n7. Exit"
        );
    }

    @Override
    public void showOperatorHomePage(String username) {
    	this.username = username;
        System.out.println(
                "\nWelcome " + username + " to BIG BOOK ENERGY.inc!"
        );

    }


    public void showOperatorMenu(){
        System.out.println(
                "\nPlease select from the following options!" +
                        "\n1. Add a document" +
                        "\n2. Remove a document" +
                        "\n3. Update document" +
                        "\n4. Demo cover art" +
                        "\n5. Exit"
        );
    }


    public void demoCoverArt() {
            CoverPanel panel = new CoverPanel();
            JFrame frame = new JFrame("Cover Art");
            frame.getContentPane().add(panel);
            frame.setSize(520,720);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

    }

    @Override
    public void showLoginPage() {
        // legacy code
//        // Logging in should query database, just a simplification to get UI running nicely
//        reader.nextLine();
//        System.out.println("Please type in your username");
//        username = reader.nextLine();
//        System.out.println("Please type in your password");
//        String password = reader.nextLine();
//
//
//
//        // just here to test what user we want! can be removed after implementation of proper login
//        while(true) {
//            System.out.println("Please type in 1 for Operator, and 2 for Registered Buyer");
//            userType = reader.nextInt();
//            if(userType == 1) {
//                showOperatorHomePage();
//                break;
//            }
//            else if(userType == 2) {
//                showRegisteredHomePage();
//                break;
//            }
//            else {
//                System.out.println("Your entry was not an option try again!");
//            }
//        }
    }

    @Override
    public Document showSubmitDocumentPage() {
        System.out.println("Document submission selected");
    	System.out.println("Please specify the file type");
    	String type = reader.nextLine();
    	while(!type.equalsIgnoreCase("PDF")&&!type.equalsIgnoreCase("DOCX")&&!type.equalsIgnoreCase("PNG"))
    	{
    		System.out.println("Please enter a valid type");
    		type = reader.nextLine();
    	}
    	return new Document(1, "hello", new ArrayList<Author>(), "November 25, 2018", type , 65);
    }

    @Override
    public void showRemoveDocumentPage(ArrayList<Document> documents) {
        System.out.println("Document removal selected.");
        displayAllDocuments(documents);
        System.out.println("Please the indicate the document you would like to remove with the corresponding index number");
    }

    @Override
    public void showUpdateDocumentPage(ArrayList<Document> documents) {
        System.out.println("Document update selected");
        displayAllDocuments(documents);
        System.out.println("Please the indicate the document you would like to update with the corresponding index number");
    }
    public void changeDocument(Document doc)
    {
    	   while(true) {
    		   try {
    			   System.out.println(
    		                 "\nPlease select one of the attribute to change!" +
    		                         "\n1. Document ID" +
    		                         "\n2. Document Name" +
    		                         "\n3. Date Created" +
    		                         "\n4. Document Price" +
    		                         "\n5. Quantity" +
    		                         "\n6. Authors"  +
    		                         "\n7. Exit"
    		        );
                   int option = reader.nextInt();
                   reader.nextLine();
                   if(option == 1) {
                       System.out.println("What would you like the document ID be?");
                       doc.setId(reader.nextInt());
                   }
                   else if (option == 2) {
                	   System.out.println("What would you like the document name be?");
                       doc.setName(reader.nextLine());
                   }
                   else if (option == 3) {
                	   System.out.println("What would you like the document date created be?");
                       doc.setDate(reader.nextLine());
                   }
                   else if (option == 4) {
                	   System.out.println("What would you like the document price be?");
                       doc.setPrice(reader.nextInt());
                   }
                   else if(option == 5){
                	   System.out.println("What would you like the document quantity be?");
                       doc.setQuantity(reader.nextInt());
                   }
                   else if(option == 6){
                	   int option2;
                	   do {
                		   System.out.println(
          		                 "\nPlease select one of the following!" +
          		                         "\n1. Add Author" +
          		                         "\n2. Remove Author" +
          		                         "\n3. Quit Author Editor");
                		   option2 = reader.nextInt();
                		   reader.nextLine();
                		   if(option2 == 1)
                		   {
                			   System.out.println("Tell me the Author's name to Add");
                               doc.getAuthors().add(new Author(reader.nextLine()));
                		   }
                		   else if(option2 == 2)
                		   {
                			   System.out.println("Tell me the Author's name to Delete");
                               for(int i =0 ; i<doc.getAuthors().size(); i++)
                               {
                            	   if(doc.getAuthors().get(i).getName().equalsIgnoreCase(reader.nextLine())) {
                            		   doc.getAuthors().remove(i);
                            		   break;
                            	   }
                               }
                		   }
                	   }while(option2!=3);
                	   
                   }
                   else if(option == 7)
                   {
                	   break;
                   }
               }
               catch (InputMismatchException ex) {
                   System.out.println("Must be an integer value!\n Please Try Again!");
               }
    	   }
    }
    private void displayAllDocuments(ArrayList<Document> documents)
    {
       System.out.println("INDEX\tID\tNAME\tDATE\t\t\tPRICE\tQUANTITY\tAUTHORS");
	   for(int i = 0; i<documents.size();i++)
       {
       	System.out.println(i + "\t" + documents.get(i).toString());
       }
    }
    @Override
    public void showPromotionListPage(ArrayList<Document> promotionList) {
        System.out.println("Here is the list of all the promotions!");
        for(Document promotion : promotionList) {
            System.out.print("\n" + promotion.getName() + "  by");
            for(Author author : promotion.getAuthors()) {
                System.out.print("  " + author.getName());
            }
            System.out.print(" is on sale for 50% off" + "\n");
        }
    }

    @Override
    public void showBookSearchPage() {
        System.out.println("Search the name of the book you're looking for!");

    }

    public void showBookFound(Document document) {
        if(document == null)
            System.out.println("No book with that name found! SORRY!");
        else {
            System.out.print("\n" + document.getName() +"   by");
            for(Author author: document.getAuthors())
            {
                System.out.print("    " + author.getName());
            }
            System.out.println("  $" + document.getPrice() +
                    "  " + document.getAvailableAmount() + " available");
        }
    }

    @Override
    public void showOrderPlacementPage() {
        System.out.println("Compose the order you'd like to place");
        System.out.println("Please search the book you'd like to order");
    }

    @Override
    public void showMakePaymentPage() {
        System.out.println("Confirm the payment you'd like to make");

    }

    @Override
    public void showRegistrationPage() {
        System.out.println("Thanks for choosing to register" +
                            "please enter your username"
        );

    }

    @Override
    public void showUnsubscribePage() {
        System.out.println("Please confirm you'd wish to unsubscribe");
    }

    @Override
    public void showDocumentListPage() {
        System.out.println("Here is the list of all the document's!");
    }

}
