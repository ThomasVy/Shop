package PresentationLayer;

import DomainLayer.Observer;

public interface UserInterface extends Observer{

    public void startingPage();
    public void showUnregisteredHomePage();
    public void showRegisteredHomePage();
    public void showOperatorHomePage();
    public void showLoginPage();
    public void showSubmitDocumentPage();
    public void showPromotionListPage();
}
