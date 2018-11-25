package PresentationLayer;

import DomainLayer.Observer;

public interface UserInterface extends Observer{

    public void showStartingPage();
    public void showUnregisteredHomePage();
    public void showRegisteredHomePage(String username);
    public void showOperatorHomePage();
    public void showLoginPage();
    public void showSubmitDocumentPage();
    public void showPromotionListPage();
}
