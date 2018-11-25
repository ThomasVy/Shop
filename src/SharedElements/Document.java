package SharedElements;

import java.util.ArrayList;

import DomainLayer.Author;
import DomainLayer.Cover;

public class Document {
    private int documentId;
    private String name;
    private ArrayList<Author> authors;
    private String dateCreated;
    private Cover cover;
    private String type;
    private String content;
    private int availableAmount;

    public Document(int documentID, String name, ArrayList<Author> authors) {
        this.documentId = documentID;
        this.name = name;
        this.authors = authors;
    }

    public String performUpload(){return new String();}

    public String getName() { return name; }

    public ArrayList<Author> getAuthors(){ return authors; }
}
