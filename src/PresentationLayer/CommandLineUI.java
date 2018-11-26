package PresentationLayer;

import DomainLayer.*;
import SharedElements.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineUI implements Observer {
    Scanner reader = new Scanner(System.in);

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void showStartingPage() {
        System.out.println("\nWelcome to BIG BOOK ENERGY, Inc!" +
                "\nWould you like to enter as a registered user or enter to just shop?" +
                "\nJust so you know registered users get access to exclusive deals!" +
                "\n1. I'd like to login" +
                "\n2. Continue as an unregistered user" +
                "\n3. Quit"
        );
    }

    public void showUnregisteredHomePage() {
        System.out.println("\nWelcome to BIG BOOK ENERGY, Inc!");
    }

    public void showUnregisteredMenu() {
        System.out.println("\nPlease select from the following options:" +
                "\n1. Search for a book" +
                "\n2. Place an order" +
                "\n3. Make a payment" +
                "\n4. Register" +
                "\n5. Simulate cover art" +
                "\n6. Exit"
        );
    }

    public void showRegisteredHomePage(String username) {
        System.out.println("\nWelcome " + username + " to BIG BOOK ENERGY, Inc!");
    }


    public void showRegisteredMenu(boolean status) {
        if(status) {
            System.out.println(
                    "\nPlease select from the following options!" +
                            "\n1. Search for a book" +
                            "\n2. Place an order" +
                            "\n3. Make a payment" +
                            "\n4. See promotions list" +
                            "\n5. Unsubscribe from promotions list" +
                            "\n6. Simulate cover art" +
                            "\n7. Simulate promotions list notification" +
                            "\n8. Exit"
            );
        }
        else {
            System.out.println(
                    "\nPlease select from the following options!" +
                            "\n1. Search for a book" +
                            "\n2. Place an order" +
                            "\n3. Make a payment" +
                            "\n4. See promotions list" +
                            "\n5. Resubscribe to promotions list" +
                            "\n6. Simulate cover art" +
                            "\n7. Simulate promotions list notification" +
                            "\n8. Exit"
            );
        }
    }

    public void showOperatorHomePage(String username) {
        System.out.println("\nWelcome " + username + " to BIG BOOK ENERGY, Inc!");
    }

    public void showOperatorMenu() {
        System.out.println("\nPlease select from the following options!" +
                "\n1. Add a document" +
                "\n2. Remove a document" +
                "\n3. Update document" +
                "\n4. Simulate cover art" +
                "\n5. Exit"
        );
    }

    public void demoCoverArt() {
        CoverPanel panel = new CoverPanel();
        JFrame frame = new JFrame("Cover Art");
        frame.getContentPane().add(panel);
        frame.setSize(520, 720);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void showSubmitDocumentPage() {
        System.out.println("Document submission selected");
    	System.out.println("Please specify the file type");
    }

    public void showRemoveDocumentPage(ArrayList<Document> documents) {
        System.out.println("Document removal selected.");
        displayAllDocuments(documents);
        System.out.println("Please indicate the document you would like to remove with the corresponding index number.");
    }

    public void showUpdateDocumentPage(ArrayList<Document> documents) {
        System.out.println("Document update selected.");
        displayAllDocuments(documents);
        System.out.println("Please indicate the document you would like to update with the corresponding index number.");
    }

    public void showDocumentUpdateOptions(Document doc) {
    	System.out.println("\n" + doc.toString());
        System.out.println("\nPlease select one of the attributes to change:" +
                "\n1. Document id" +
                "\n2. Document name" +
                "\n3. Date created" +
                "\n4. Document price" +
                "\n5. Quantity" +
                "\n6. Authors" +
                "\n7. Exit"
        );
    }

    public void showAuthorOptions() {
        System.out.println("\nPlease select one of the following:" +
                "\n1. Add author" +
                "\n2. Remove author" +
                "\n3. Quit author editor"
        );
    }

    public void displayAllDocuments(ArrayList<Document> documents)
    {
       System.out.println("Format(INDEX: ID: NAME: DATE: PRICE: QUANTITY: AUTHORS)");
	   for(int i = 0; i<documents.size();i++)
       {
       	System.out.println(i + "    " + documents.get(i).toString());
       	System.out.flush();
       }
    }

    public void showPromotionsListPage(ArrayList<Document> promotionList) {
        System.out.println("\nHere is the list of all the promotions:");
        for (Document promotion : promotionList) {
            System.out.print("\n" + promotion.getName() + "  by");
            for (Author author : promotion.getAuthors()) {
                System.out.print("  " + author.getName());
            }
            System.out.print(" is on sale for 50% off" + "\n");
        }
    }

    public void showBookSearchPage() {
        System.out.println("\nSearch the name of the book you're looking for.");
    }

    public void showBookFound(Document document) {
        if (document == null)
            System.out.println("\nNo book with that name found! Sorry!");
        else {
            System.out.print("\n" + document.getName() + "   by");
            for (Author author : document.getAuthors()) {
                System.out.print("    " + author.getName());
            }
            System.out.println("  $" + document.getPrice() +
                    "  " + document.getAvailableAmount() + " available");
        }
    }

    public void showOrderPlacementPage() {
        System.out.println("\nCompose the order you'd like to place");
    }

    public void showFinalOrder(Order order) {
        System.out.println("Order#" + order.getOrderId() + " will cost $" + order.getAmount() +
                "\nShipping Address: " + order.getShippingAddress() +
                "\nDate Ordered: " + order.getDateOrdered()
        );
        for (Document doc : order.getItems()) {
            System.out.println("Item: " + doc.getName() + "     $" + doc.getPrice());
        }
        System.out.println("Total Amount Owed: $" + order.getAmount());
    }

    public void showMakePaymentPage() {
        System.out.println("\nConfirm the payment you'd like to make.");
    }

    public void showRegistrationPage() {
        System.out.println("\nThanks for choosing to register!");
    }

    public void showUnsubscribePage() {
        System.out.println("\nPlease confirm you'd wish to unsubscribe.");
    }

    public void showResubscribePage() { System.out.println("Please confirm you'd wish to subscribe"); }

    @Override
    public void showNotification() {
        System.out.println("\nThe promotions list has been updated!");
    }

}
