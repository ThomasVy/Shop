package PresentationLayer;

import DomainLayer.*;

public class Demo {

    public static void main(String[] args) {
        CommandLineUI ui = new CommandLineUI();
        OnlineSystem os = OnlineSystem.getInstance();
        os.startup(ui);
    }

}
