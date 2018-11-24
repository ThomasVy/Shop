package SharedElements;

public class Manager extends StaffMember {
	public Manager(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isManager = true;
		this.isOperator = false;
		this.isSystemAdmin = false;
	}
}
