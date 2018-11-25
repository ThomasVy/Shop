package SharedElements;

public class RegisteredBuyer extends User {

	boolean subscription;
	public RegisteredBuyer()
	{

	}
	public RegisteredBuyer(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.subscription = true;
	}
}
