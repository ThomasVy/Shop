package PresentationLayer;

import DomainLayer.Observer;
import SharedElements.Document;

public interface UserInterface extends Observer{

    public void showStartingPage();
    public void showUnregisteredHomePage();

    public void showRegisteredHomePage(String username);
    public void showOperatorHomePage(String username);
    
    public void showLoginPage();
    public Document showSubmitDocumentPage();
    public void showRemoveDocumentPage();
    public void showUpdateDocumentPage();
    public void showPromotionListPage();
    public void showBookSearchPage();
    public void showOrderPlacementPage();
    public void showMakePaymentPage();
    public void showRegistrationPage();
    public void showUnsubscribePage();
}
