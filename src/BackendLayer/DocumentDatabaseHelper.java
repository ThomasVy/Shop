package BackendLayer;

import java.util.ArrayList;
import SharedElements.*;

public class DocumentDatabaseHelper implements DatabaseHelper {
	private ArrayList<Document> DocumentDatabase = new ArrayList<Document>();
	
	public DocumentDatabaseHelper() {
		
	}
	
	@Override
	public void insert(Object object) {
		DocumentDatabase.add((Document) object);
	}

	@Override
	public void delete(Object object) {
		for (int i = 0; i < DocumentDatabase.size(); i++) {
			if (DocumentDatabase.get(i) == object) {
				DocumentDatabase.remove(i);
			}
		}
	}

	@Override
	public Object select(Object object) {
		for (int i = 0; i < DocumentDatabase.size(); i++) {
			if (DocumentDatabase.get(i) == object) {
				return DocumentDatabase.get(i);
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
