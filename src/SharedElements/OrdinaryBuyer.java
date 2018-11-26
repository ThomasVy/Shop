package SharedElements;

public class OrdinaryBuyer extends User{
    static int id;
    String username;
    public OrdinaryBuyer(){
        id++;
        username = "" + id;
    }
}
