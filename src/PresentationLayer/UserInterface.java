package PresentationLayer;

import DomainLayer.Observer;
import DomainLayer.Page;

public interface UserInterface extends Observer{
    public Page showHomePage();
    public Page showLoginPage();
    public Page showSubmitDocumentPage();
    public Page showPromotionListPage();
}
