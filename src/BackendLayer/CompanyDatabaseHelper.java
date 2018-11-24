package BackendLayer;

import java.util.ArrayList;
import SharedElements.*;

public class CompanyDatabaseHelper implements DatabaseHelper {
    @Override
    public void insert(Object object) {
    }
	private ArrayList<User> CompanyDatabase = new ArrayList<User>();
	
	public CompanyDatabaseHelper() {

	}

	@Override
	public void insert(Object object) {
		CompanyDatabase.add((User) object);
	}

	@Override
	public void delete(Object object) {
		for (int i = 0; i < CompanyDatabase.size(); i++) {
			if (CompanyDatabase.get(i) == object) {
				CompanyDatabase.remove(i);
			}
		}
	}

	@Override
	public Object select(Object object) {
		for (int i = 0; i < CompanyDatabase.size(); i++) {
			if (CompanyDatabase.get(i) == object) {
				return CompanyDatabase.get(i);
			}
		}
		return null;
	}

	@Override
	public void modify(Object original, Object modified) {
		Object toBeModified = select(original);
		toBeModified = modified;
	}
}
