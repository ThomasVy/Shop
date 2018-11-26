package BackendLayer;

import java.util.ArrayList;

import DomainLayer.Author;
import SharedElements.*;

public class DocumentDatabaseHelper implements DatabaseHelper {
	private ArrayList<Document> DocumentDatabase = new ArrayList<Document>();
	
	public DocumentDatabaseHelper() {
		// hardcoded for testing promotion list
		ArrayList<Author> authors1 = new ArrayList<Author>();
		authors1.add(new Author("Dave Pilkey"));
		//DocumentDatabase.add(new Document(1,"Captain Underpants", authors1, 9.99, 30));
	}

	public ArrayList<Document> getDocumentDatabase() {
		return DocumentDatabase;
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
