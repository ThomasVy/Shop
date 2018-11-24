package BackendLayer;

import java.util.ArrayList;
import SharedElements.*;

public class UserDatabaseHelper implements DatabaseHelper {
	private ArrayList<User> UserDatabase = new ArrayList<User>();

	public UserDatabaseHelper() {
		
	}

	@Override
	public void insert(Object object) {
		UserDatabase.add((User) object);
	}

	@Override
	public void delete(Object object) {
		for (int i = 0; i < UserDatabase.size(); i++) {
			if (UserDatabase.get(i) == object) {
				UserDatabase.remove(i);
			}
		}
	}

	@Override
	public Object select(Object object) {
		for (int i = 0; i < UserDatabase.size(); i++) {
			if (UserDatabase.get(i) == object) {
				return UserDatabase.get(i);
			}
		}
		return null;
	}

	@Override
	public void modify(Object original, Object modified) {
		Object toBeModified = select(original);
		toBeModified = modified;
	}

	public Object verifyUser(User user) {
		return null;
    }
}
