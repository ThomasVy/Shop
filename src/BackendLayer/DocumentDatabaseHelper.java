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
		DocumentDatabase.add(new Document(1,"Captain Underpants", authors1, "September 1st 1997", "pdf",30, 9.99));
		ArrayList<Author> authors2 = new ArrayList<>();
		authors2.add(new Author("George R.R. Martin"));
		DocumentDatabase.add(new Document(2,"Game of Thrones", authors2, "August 1st 1996", "docx",2,15.99));
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
