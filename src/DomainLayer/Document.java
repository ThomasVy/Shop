package DomainLayer;

import java.util.ArrayList;

public class Document {
    private int documentId;
    private String name;
    private ArrayList<Author> authors;
    private String dateCreated;
    private Cover cover;
    private String type;
    private String content;
    private int availableAmount;

    public String performUpload(){return new String();}
}
