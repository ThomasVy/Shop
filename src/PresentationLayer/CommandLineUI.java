package PresentationLayer;

import DomainLayer.*;

import SharedElements.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineUI implements Observer {

    Scanner reader = new Scanner(System.in);

    // userType == 1 -> user is an Operator
    // userType == 2 -> user is a Register Buyer
    // userType == 3 -> user is an Unregistered Buyer
    // this can be swapped with static User type when everything else is implemented
    // just check what type of user they are after
    public CommandLineUI() {
    }

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

    public void showRegisteredHomePage(String username) { 
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
                        "\n4. See promotions list" +
                        "\n5. Unsubscribe from promotions list" +
                        "\n6. Demo cover art" +
                        "\n7. Simulate promotions list notification" +
                        "\n8. Exit"
        );
    }

    public void showOperatorHomePage(String username) {
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

    public Document showSubmitDocumentPage() {
        System.out.println("Document submission selected");
    	System.out.println("Please specify the file type");
    	String type = reader.nextLine();
    	while(!type.equalsIgnoreCase("PDF")&&!type.equalsIgnoreCase("DOCX")&&!type.equalsIgnoreCase("PNG"))
    	{
    		System.out.println("Please enter a valid type");
    		type = reader.nextLine();
    	}
    	return new Document(1, "A Long Book", new ArrayList<Author>(), "November 25, 2018", type , 65, 12.99);

    }

    public void showRemoveDocumentPage(ArrayList<Document> documents) {
        System.out.println("Document removal selected.");
        displayAllDocuments(documents);
        System.out.println("Please the indicate the document you would like to remove with the corresponding index number");
    }

    public void showUpdateDocumentPage(ArrayList<Document> documents) {
        System.out.println("Document update selected");
        displayAllDocuments(documents);
        System.out.println("Please the indicate the document you would like to update with the corresponding index number");
    }
    public void changeDocument(Document doc)
    {
    	   while(true) {
    		   try {
    			   System.out.println(doc);
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
       System.out.println("Format(INDEX: ID: NAME: DATE: PRICE: QUANTITY: AUTHORS)");
	   for(int i = 0; i<documents.size();i++)
       {
       	System.out.println(i + "    " + documents.get(i).toString());
       	System.out.flush();
       }
    }

    
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

    public void showOrderPlacementPage() {
        System.out.println("Compose the order you'd like to place");
    }

    public void showFinalOrder(Order order) {
        System.out.println("Order#" + order.getOrderId() + " will cost $" + order.getAmount() +
                            "\nShipping Address: " + order.getShippingAddress() +
                            "\nDate Ordered: " + order.getDateOrdered()
        );

        for(Document doc: order.getItems()) {
            System.out.println("Item: " + doc.getName() + "     $" + doc.getPrice());
        }

        System.out.println("Total Amount Owed: $" + order.getAmount());
    }


    public void showMakePaymentPage() {
        System.out.println("Confirm the payment you'd like to make");
    }

 
    public void showRegistrationPage() {
        System.out.println("Thanks for choosing to register");
    }

    public void showUnsubscribePage() {
        System.out.println("Please confirm you'd wish to unsubscribe");
    }

    public void showNotification() {
        System.out.println("The promotions list has been updated");
    }

}
