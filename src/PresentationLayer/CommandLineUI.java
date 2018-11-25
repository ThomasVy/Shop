package PresentationLayer;

import DomainLayer.*;

import javax.swing.*;
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
            int option;
            while(true){
                System.out.println(
                        "\nPlease select from the following options!" +
                                "\n1. Search for a book" +
                                "\n2. Place an order" +
                                "\n3. Make a payment" +
                                "\n4. Register" +
                                "\n5. Demo cover art" +
                                "\n6. Exit" +
                                "\n7. Testing Upload"
                );
                option = reader.nextInt();
                if(option == 6) {
                    System.out.println("\nHave a nice day! Please comeback again");
                    System.exit(0);
                }
                else if(option == 7)
                {
                	OnlineSystem.getInstance().
                }
                else if(option == 5) {
                    demoCoverArt();
                }
                else {
                    System.out.println("Your entry was not an option try again!");
                }
            }
    }

    @Override
    public void showRegisteredHomePage(String username) {
    	this.username = username;
        System.out.println(
                        "\nWelcome " + username + " to BIG BOOK ENERGY.inc!"
        );

        int option;
        while (true) {
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
            option = reader.nextInt();
            if (option == 7) {
                System.out.println("\nHave a nice day! Please comeback again");
                System.exit(1);
            }
            else if(option == 6) {
                demoCoverArt();
            }else {
                System.out.println("Your entry was not an option try again!");
            }
        }
    }

    @Override
    public void showOperatorHomePage() {

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
    public void showSubmitDocumentPage() {

    }

    @Override
    public void showPromotionListPage() {

    }

    @Override
    public void showDocumentListPage() {

    }

}
