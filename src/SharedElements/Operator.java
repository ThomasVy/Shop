package SharedElements;

public class Operator extends StaffMember {
	public Operator(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isManager = false;
		this.isOperator = true;
		this.isSystemAdmin = false;
	}
}
