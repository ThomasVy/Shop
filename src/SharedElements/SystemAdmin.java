package SharedElements;

public class SystemAdmin extends StaffMember {
	int adminLevel;

	public SystemAdmin(String username, String password, String name, String email, int adminLevel) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isManager = false;
		this.isOperator = false;
		this.isSystemAdmin = true;
		this.adminLevel = adminLevel;
	}
}
